package com.kn.contactlist.service.impl;

import com.kn.contactlist.common.error.ErrorCodes;
import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.exception.type.BusinessException;
import com.kn.contactlist.model.ContactTable;
import com.kn.contactlist.repository.ContactRepository;
import com.kn.contactlist.service.ContactListService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ContactListServiceImpl implements ContactListService {

    private final ContactRepository contactRepository;

    public ContactListServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactDto> findAllContacts() throws BusinessException {
        List<ContactTable> contactTableList = contactRepository.findAll();

        if (contactTableList.isEmpty()) {
            throw new BusinessException(ErrorCodes.ERROR_CODE_CONTACT_NOT_FOUND_EXCEPTION);
        }

        List<ContactDto> contactDtoList = new LinkedList<>();

        for (ContactTable contactTable : contactTableList) {
            ContactDto contactDto = new ContactDto();
            contactDto.setName(contactTable.getName());
            contactDto.setUrl(contactTable.getUrl());
            contactDtoList.add(contactDto);
        }
        return contactDtoList;
    }
}
