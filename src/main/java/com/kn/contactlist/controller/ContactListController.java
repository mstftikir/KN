package com.kn.contactlist.controller;

import com.kn.contactlist.common.controller.ControllerResponse;
import com.kn.contactlist.exception.type.BusinessException;
import com.kn.contactlist.response.ContactResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/contacts")
public interface ContactListController {

    @GetMapping
    ResponseEntity<ControllerResponse<List<ContactResponse>>> findAllContacts() throws BusinessException;
}
