package com.example;

import com.example.service.RegulatedUseService;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceException;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class RegulatedServiceFactory implements ServiceFactory<RegulatedUseService> {

    private Bundle bundleCurrentlyHoldingService;

    private final RegulatedUseService regulatedUseService;

    public RegulatedServiceFactory(final RegulatedUseService regulatedUseService) {
        this.regulatedUseService = regulatedUseService;
    }

    public RegulatedUseService getService(final Bundle bundle, final ServiceRegistration<RegulatedUseService> serviceRegistration) {
        if (bundleCurrentlyHoldingService != null && bundle != bundleCurrentlyHoldingService)
        {
            throw new ServiceException("Attempting to obtain service already held.", ServiceException.FACTORY_EXCEPTION);
        }
        bundleCurrentlyHoldingService = bundle;
        return regulatedUseService;
    }

    public void ungetService(final Bundle bundle, final ServiceRegistration<RegulatedUseService> serviceRegistration, final RegulatedUseService regulatedUseService) {
        if (bundle == bundleCurrentlyHoldingService)
        {
            bundleCurrentlyHoldingService = null;
        }
    }
}
