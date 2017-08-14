package com.example.consumertwo;

import com.example.service.RegulatedUseService;

public class ConsumerTwo {

    private RegulatedUseService regulatedUseService;

    public void bindRegulatedUseService(final RegulatedUseService regulatedUseservice)
    {
        this.regulatedUseService = regulatedUseservice;
    }

    public void unbindRegulatedUseService(final RegulatedUseService regulatedUseService)
    {
        if (regulatedUseService == this.regulatedUseService)
        {
            this.regulatedUseService = null;
        }
    }
}
