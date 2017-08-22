package com.example.commands;

import com.example.service.ConsumerService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "command", name="two", description = "Initiates CommandTwo")
@Service
public class CommandTwo  implements Action{

    @Reference
    private ConsumerService consumerService;

    @Override
    public Object execute() throws Exception {
        consumerService.useRegulatedService();
        return null;
    }
}
