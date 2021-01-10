package com.kn.contactlist.utlis;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileUtils {

    public String getPeopleFilePath() {
        return System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "data"
                + File.separator + "people.csv";
    }
}
