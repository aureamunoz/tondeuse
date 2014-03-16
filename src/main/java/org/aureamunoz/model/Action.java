package org.aureamunoz.model;

public enum Action {

    DROITE ('D'), GAUCHE ('G'), AVANCE ('A');

    private char name;

    private Action(char name) {
        this.name = name;
    }

    public static Action getActionfromName(final char name)
    {
        for (Action action : Action.values())
            if (action.name == name)
                return action;

        throw new AssertionError("Unknown action: " + name);
    }

}
