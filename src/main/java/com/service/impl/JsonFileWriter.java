package com.service.impl;

import com.service.FileWriter;

import java.io.File;

public class JsonFileWriter implements FileWriter {

    private File outputFile;

    public JsonFileWriter(File outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public boolean writeFile() {

        //write json file writer to convert pojo in to json data

        return false;
    }
}
