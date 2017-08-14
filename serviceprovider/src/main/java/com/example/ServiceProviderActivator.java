package com.example;

import com.example.service.RegulatedUseService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceProviderActivator implements BundleActivator {

    private ServiceRegistration serviceRegistration;

    private RegulatedServiceFactory factory = new RegulatedServiceFactory(new RegulatedUseServiceImpl());

    public void start(final BundleContext bundleContext) throws Exception {
        serviceRegistration = bundleContext.registerService(RegulatedUseService.class, factory, null);
    }

    public void stop(final BundleContext bundleContext) throws Exception {
        serviceRegistration.unregister();
    }
}
