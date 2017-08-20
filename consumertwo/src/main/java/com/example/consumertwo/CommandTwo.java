package com.example.consumertwo;

import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;

@Command(scope = "command", name="two", description = "Initiates CommandTwo")
public class CommandTwo  implements Action{

    private final ConsumerTwo consumerTwo;

    public CommandTwo(final ConsumerTwo consumerTwo) {
        this.consumerTwo = consumerTwo;
    }

    @Override
    public Object execute() throws Exception {
        consumerTwo.useRegulatedService();
        return null;
    }
}
