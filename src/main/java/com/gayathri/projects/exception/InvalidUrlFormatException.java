package com.gayathri.projects.exception;

public class InvalidUrlFormatException extends RuntimeException
{
    public InvalidUrlFormatException(String message)
    {
        super(message);
    }
}