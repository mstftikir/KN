package com.kn.contactlist.controller.impl;

import com.kn.contactlist.common.CommonVariables;
import com.kn.contactlist.common.controller.ControllerResponse;
import com.kn.contactlist.common.controller.ControllerResponseBuilder;
import com.kn.contactlist.controller.ContactListController;
import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.exception.type.BusinessException;
import com.kn.contactlist.mapper.ContactMapper;
import com.kn.contactlist.response.ContactResponse;
import com.kn.contactlist.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactListControllerImpl implements ContactListController {

    private final ContactListService contactListService;

    private final ContactMapper contactMapper;

    @Autowired
    public ContactListControllerImpl(ContactListService contactListService, ContactMapper contactMapper) {
        this.contactListService = contactListService;
        this.contactMapper = contactMapper;
    }

    @Override
    @CachePut(value="contactList")
    public ResponseEntity<ControllerResponse<List<ContactResponse>>> findAllContacts() throws BusinessException {
        List<ContactDto> contactDtoList = contactListService.findAllContacts();

        List<ContactResponse> contactResponseList = contactMapper.mapContactDtoToResponse(contactDtoList);

        return ControllerResponseBuilder.success(contactResponseList, CommonVariables.ControllerReturnMessages.SUCCESS.toString());
    }
}
