package com.ianmcnicholas.util;

public enum Command {
    PLACE(true),  // requires arguments
    MOVE(false),
    LEFT(false),
    RIGHT(false),
    REPORT(false),
    HELP(false),
    EXIT(false);

    private final boolean requiresArgs;

    Command(boolean requiresArgs) {
        this.requiresArgs = requiresArgs;
    }

    public boolean requiresArgs() {
        return requiresArgs;
    }
}
