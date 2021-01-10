package com.kn.contactlist.service;

import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.exception.type.BusinessException;

import java.util.List;

public interface ContactListService {
    List<ContactDto> findAllContacts() throws BusinessException;
}
