package com.example.consumertwo;

import com.example.service.RegulatedUseService;
import org.apache.karaf.shell.api.action.Action;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Properties;

public class ConsumerTwo {

    private BundleContext bundleContext;

    private RegulatedUseService regulatedUseService;

    private ServiceRegistration<Action> commandTwoServiceAction;

    private final Dictionary<String, String> metaData = new Hashtable<>();

    public ConsumerTwo() {
        metaData.put("scope", "command");
        metaData.put("name", "two");
        metaData.put("description", "Uses the consumer two");
    }

    public void useRegulatedService()
    {
        Object service = regulatedUseService.getRegulatedObject();
        System.out.println(service.toString());
    }

    public void bindRegulatedUseService(final RegulatedUseService regulatedUseservice)
    {
        this.regulatedUseService = regulatedUseservice;
        final CommandTwo commandTwo = new CommandTwo(this);
        commandTwoServiceAction = bundleContext.registerService(Action.class, commandTwo, metaData);
    }

    public void unbindRegulatedUseService(final RegulatedUseService regulatedUseService)
    {
        if (regulatedUseService == this.regulatedUseService)
        {
            commandTwoServiceAction.unregister();
            this.regulatedUseService = null;
        }
    }

    public void setBundleContext(final BundleContext bundleContext)
    {
        this.bundleContext = bundleContext;
    }
}
