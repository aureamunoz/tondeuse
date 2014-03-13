public enum Direction {
    NORTH {
        Direction turnLeft(){ return WEST;}
        Direction turnRight(){ return EAST;}
    },
    SOUTH {
        Direction turnLeft(){ return EAST;}
        Direction turnRight(){ return WEST;}
    },
    EAST {
        Direction turnLeft(){ return NORTH;}
        Direction turnRight(){ return SOUTH;}
    },
    WEST {
        Direction turnLeft(){return SOUTH;}
        Direction turnRight(){ return NORTH;}
    };

    abstract Direction turnLeft();
    abstract Direction turnRight();
}
