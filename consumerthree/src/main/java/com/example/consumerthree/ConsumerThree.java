package com.example.consumerthree;

import com.example.service.RegulatedUseService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public class ConsumerThree implements BundleActivator {

    ServiceTracker serviceTracker;

    RegulatedUseService regulatedUseService;

    @Override
    public void start(final BundleContext bundleContext) throws Exception {

        serviceTracker = new ServiceTracker(bundleContext, RegulatedUseService.class.getName(), null);
        serviceTracker.open();

        regulatedUseService = (RegulatedUseService) serviceTracker.getService();

        Object regulatedObject = regulatedUseService.getRegulatedObject();

    }

    @Override
    public void stop(final BundleContext bundleContext) throws Exception {

        regulatedUseService = null;
        serviceTracker.close();

    }

}
