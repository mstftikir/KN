package com.kn.contactlist.controller.impl;

import com.kn.contactlist.common.controller.ControllerResponse;
import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.exception.type.BusinessException;
import com.kn.contactlist.mapper.ContactMapper;
import com.kn.contactlist.response.ContactResponse;
import com.kn.contactlist.service.impl.ContactListServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ContactListControllerImplTests {

    @Mock
    private ContactListServiceImpl contactListService;

    @Spy
    private ContactMapper contactMapper;

    @InjectMocks
    private ContactListControllerImpl contactListController;

    private static final String name = "Test Name";

    private static final String url = "Test Url";

    private final List<ContactDto> contactDtoList = new LinkedList<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ContactDto contactDto = new ContactDto();
        contactDto.setName(name);
        contactDto.setUrl(url);
        contactDtoList.add(contactDto);
    }

    @Test
    public void findAllContactsHttpStatusTest() throws BusinessException {
        Mockito.when(contactListService.findAllContacts()).thenReturn(contactDtoList);

        ResponseEntity<ControllerResponse<List<ContactResponse>>> contactListResponse = contactListController.findAllContacts();

        Assert.assertEquals(HttpStatus.OK, contactListResponse.getStatusCode());
    }

    @Test
    public void findAllContactsValueTest() throws BusinessException {
        Mockito.when(contactListService.findAllContacts()).thenReturn(contactDtoList);

        ResponseEntity<ControllerResponse<List<ContactResponse>>> contactListResponse = contactListController.findAllContacts();

        Assert.assertEquals(name, Objects.requireNonNull(contactListResponse.getBody()).getData().get(0).getName());
        Assert.assertEquals(url, Objects.requireNonNull(contactListResponse.getBody()).getData().get(0).getUrl());
    }
}
