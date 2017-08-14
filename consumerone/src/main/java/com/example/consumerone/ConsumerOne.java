package com.example.consumerone;

import com.example.service.RegulatedUseService;

public class ConsumerOne {

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
