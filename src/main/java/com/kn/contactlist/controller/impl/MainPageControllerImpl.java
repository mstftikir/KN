package com.kn.contactlist.controller.impl;

import com.kn.contactlist.common.CommonVariables;
import com.kn.contactlist.controller.MainPageController;
import org.springframework.stereotype.Controller;

@Controller
public class MainPageControllerImpl implements MainPageController {

    @Override
    public String index() {
        return CommonVariables.INDEX;
    }
}
