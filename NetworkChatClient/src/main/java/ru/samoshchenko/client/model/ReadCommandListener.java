package ru.samoshchenko.client.model;

import ru.samoshchenko.clientserver.Command;

public interface ReadCommandListener {

    void processReceivedCommand(Command command);

}
