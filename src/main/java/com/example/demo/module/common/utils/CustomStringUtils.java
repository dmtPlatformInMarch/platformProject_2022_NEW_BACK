package com.example.demo.module.common.utils;

public class CustomStringUtils {
    public boolean isObjectNull(Object object) {
        if(object == null || object.equals("") || object.equals(" "))
            return true;
        else
            return false;
    }
}
