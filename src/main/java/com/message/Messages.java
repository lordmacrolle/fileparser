package com.message;

public interface Messages {

    String FILE_ERROR = "input file is invalid, provide a valid input file";
    String EXTENSION_MISMATCH = "input file extension is differ from the provided file parser";
    String INVALID_ARGUMENT = "please provide two valid arguments for input and output file path";
    String FILE_WRITE_EXCEPTION = "exception occurred while writing the file at destination";
    String SUCCESS = "Successfully processed records %s";
    String EMP_ADDITION = "Employee %s successfully added";
    String EMP_REMOVE = "Employee removed status %s for %s";
}

