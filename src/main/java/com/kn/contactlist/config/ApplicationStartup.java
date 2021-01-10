package com.kn.contactlist.config;

import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.utils.ContactUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.List;

@Configuration
public class ApplicationStartup {

    private final ContactUtils contactUtils;

    @Autowired
    public ApplicationStartup(ContactUtils contactUtils) {
        this.contactUtils = contactUtils;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void saveDataToDatabase() {
        List<ContactDto> contactDtoList = contactUtils.getContactsFromFile();
        contactUtils.saveContactsToDatabase(contactDtoList);
    }
}
