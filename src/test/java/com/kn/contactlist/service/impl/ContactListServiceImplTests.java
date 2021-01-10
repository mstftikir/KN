package com.kn.contactlist.service.impl;

import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.exception.type.BusinessException;
import com.kn.contactlist.model.ContactTable;
import com.kn.contactlist.repository.ContactRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ContactListServiceImplTests {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactListServiceImpl contactListService;

    private static final String name = "Test Name";

    private static final String url = "Test Url";

    private static final String serviceUserId = "10000";

    private final List<ContactTable> contactTableList = new LinkedList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ContactTable contactTable = new ContactTable();
        contactTable.setName(name);
        contactTable.setUrl(url);
        contactTable.setCreateTime(new Date());
        contactTable.setCreateUserId(serviceUserId);
        contactTable.setUpdateTime(new Date());
        contactTable.setUpdateUserId(serviceUserId);

        contactTableList.add(contactTable);
    }

    @Test
    public void findAllContactsExceptionTest(){
        Mockito.when(contactRepository.findAll()).thenReturn(new LinkedList<>());

        Assertions.assertThrows(BusinessException.class, () -> contactListService.findAllContacts());
    }

    @Test
    public void findAllContactsCorrectValueTest() throws BusinessException {
        Mockito.when(contactRepository.findAll()).thenReturn(contactTableList);

        List<ContactDto> contactDtoList = contactListService.findAllContacts();

        Assert.assertNotNull(contactDtoList);
        Assert.assertEquals(name, contactDtoList.get(0).getName());
        Assert.assertEquals(url, contactDtoList.get(0).getUrl());
    }

}
