package com.example;

import com.example.service.RegulatedUseService;

public class RegulatedUseServiceImpl implements RegulatedUseService {

    private final Object regulatedObject = new Object();

    public Object getRegulatedObject() {
        return regulatedObject;
    }
}
