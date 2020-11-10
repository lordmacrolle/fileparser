package com.service;

import java.io.File;

public interface FileParser {
    void readFile(File file);
    void addEmployee(File file);
    void deleteEmployee(String name);
}
