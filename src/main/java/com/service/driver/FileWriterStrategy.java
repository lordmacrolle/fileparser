package com.service.driver;

import com.service.FileWriter;

public class FileWriterStrategy{

    private FileWriter fileWriter;

    public FileWriterStrategy(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public boolean generateEmployeeFile() {
        return this.fileWriter.writeFile();
    }
}
