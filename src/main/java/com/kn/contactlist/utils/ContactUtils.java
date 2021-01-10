package com.kn.contactlist.utils;

import com.kn.contactlist.common.CommonVariables;
import com.kn.contactlist.common.error.ErrorCodes;
import com.kn.contactlist.common.error.ErrorMessages;
import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.model.ContactTable;
import com.kn.contactlist.repository.ContactRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static com.kn.contactlist.constants.ApplicationConstants.COMMA_DELIMITER;

@Component
public class ContactUtils {

    private static final Logger logger = LogManager.getLogger(ContactUtils.class);

    private final FileUtils fileUtils;

    private final ContactRepository contactRepository;

    private final ErrorMessages errorMessages;

    @Autowired
    public ContactUtils(FileUtils fileUtils, ContactRepository contactRepository, ErrorMessages errorMessages) {
        this.fileUtils = fileUtils;
        this.contactRepository = contactRepository;
        this.errorMessages = errorMessages;
    }

    public List<ContactDto> getContactsFromFile() {
        List<ContactDto> contactDtoList = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileUtils.getPeopleFilePath()))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                if (counter++ == 0) {
                    continue;
                }

                String[] values = line.split(COMMA_DELIMITER);
                StringBuilder fullName = new StringBuilder();

                // Because last value in row is the url
                // All values before the url consists the name
                // So, append all to fullName
                for (int i = 0; i < values.length - 1; i++) {
                    fullName.append(values[i]);
                }

                ContactDto contactDto = new ContactDto();
                contactDto.setName(fullName.toString());

                //get last value which is url
                contactDto.setUrl(values[values.length - 1]);

                contactDtoList.add(contactDto);
            }
        } catch (IOException ex) {
            logger.error(errorMessages.getErrorMessage(ErrorCodes.ERROR_CODE_CONTACT_READ_FROM_FILE_EXCEPTION), ex);
        }

        return contactDtoList;
    }

    public void saveContactsToDatabase(List<ContactDto> contactDtoList) {
        List<ContactTable> contactTableList = new ArrayList<>(contactDtoList.size());

        for (ContactDto contactDto : contactDtoList) {
            ContactTable contactTable = new ContactTable();
            contactTable.setName(contactDto.getName());
            contactTable.setUrl(contactDto.getUrl());
            contactTable.setCreateUserId(CommonVariables.SERVICE_USER_ID);
            contactTable.setUpdateTime(new Date());
            contactTable.setUpdateUserId(CommonVariables.SERVICE_USER_ID);
            contactTableList.add(contactTable);
        }

        contactRepository.saveAll(contactTableList);
    }

}
