package com.kn.contactlist.mapper;

import com.kn.contactlist.dto.ContactDto;
import com.kn.contactlist.response.ContactResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactMapper {

    public List<ContactResponse> mapContactDtoToResponse(List<ContactDto> contactDtoList) {
        List<ContactResponse> contactResponseList = new ArrayList<>(contactDtoList.size());

        for (ContactDto contactDto : contactDtoList) {
            ContactResponse contactResponse = new ContactResponse();
            contactResponse.setName(contactDto.getName());
            contactResponse.setUrl(contactDto.getUrl());

            contactResponseList.add(contactResponse);
        }

        return contactResponseList;
    }

}
