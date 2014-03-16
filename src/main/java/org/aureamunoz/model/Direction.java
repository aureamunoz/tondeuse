package org.aureamunoz.model;

public enum Direction {
    NORTH ('N'){
        Direction turnLeft(){ return WEST;}
        Direction turnRight(){ return EAST;}
    },
    SOUTH ('S'){
        Direction turnLeft(){ return EAST;}
        Direction turnRight(){ return WEST;}
    },
    EAST('E') {
        Direction turnLeft(){ return NORTH;}
        Direction turnRight(){ return SOUTH;}
    },
    WEST ('W'){
        Direction turnLeft(){return SOUTH;}
        Direction turnRight(){ return NORTH;}
    };

    private char name;

    private Direction(char name) {
        this.name = name;
    }

    public static Direction getDirectionfromName(final char name)
    {
        for (Direction dir : Direction.values())
            if (dir.name == name)
                return dir;

        throw new AssertionError("Unknown direction: " + name);
    }

    abstract Direction turnLeft();
    abstract Direction turnRight();
}
