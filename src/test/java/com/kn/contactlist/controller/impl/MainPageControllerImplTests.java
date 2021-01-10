package com.kn.contactlist.controller.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MainPageControllerImplTests {

    private static final String INDEX = "index";

    @InjectMocks
    private MainPageControllerImpl mainPageController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void indexValueTest() {
        Assert.assertEquals(INDEX, mainPageController.index());
    }
}
