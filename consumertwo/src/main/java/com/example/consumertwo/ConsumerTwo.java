package com.example.consumertwo;

import com.example.service.ConsumerService;
import com.example.service.RegulatedUseService;
import org.osgi.framework.BundleContext;

public class ConsumerTwo implements ConsumerService {

    private BundleContext bundleContext;

    private RegulatedUseService regulatedUseService;

    @Override
    public void useRegulatedService()
    {
        Object service = regulatedUseService.getRegulatedObject();
        System.out.println(service.toString());
    }

    public void setRegulatedUseService(final RegulatedUseService regulatedUseService)
    {
        this.regulatedUseService = regulatedUseService;
    }

    public void setBundleContext(final BundleContext bundleContext)
    {
        this.bundleContext = bundleContext;
    }

}
