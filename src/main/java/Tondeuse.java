

import com.google.common.base.Objects;
import org.apache.commons.lang3.StringUtils;

public class Tondeuse {

    private Position position;
    private Direction direction;


    public Tondeuse(int x, int y, String direction) {
        this.position = new Position(x,y);
        this.direction = Direction.valueOf(direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tondeuse tondeuse = (Tondeuse) obj;

        return Objects.equal(this.position, tondeuse.position) && Objects.equal(this.direction, tondeuse.direction);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position, direction);
    }

    public void move(String instructions) {
        if (StringUtils.isNotEmpty(instructions)) {
            for (char mv : instructions.toCharArray()) {
                move(Action.getActionfromName(mv));
            }
        }
    }



    public void move(Action instruction) {
        switch (instruction) {
            case DROITE:
                turnRight();
                break;
            case GAUCHE:
                turnLeft();
                break;
            case AVANCE:
                goAheadIfPossible();
                break;

        }

    }

    public void turnRight(){
        this.direction = this.direction.turnRight();
    }

    public void turnLeft(){
        this.direction = this.direction.turnLeft();
    }


    public void goAheadIfPossible() {
        //TODO Optional<position>
        Position newPosition = null;
        switch (this.direction) {
            case NORTH:
                newPosition = getNewPosition(this.position, 0, 1);
                break;
            case EAST:
                newPosition = getNewPosition(this.position, 1, 0);
                break;
            case SOUTH:
                newPosition = getNewPosition(this.position, 0, -1);
                break;
            case WEST:
                newPosition = getNewPosition(this.position, -1, 0);
                break;
        }
        if (newPosition.isValid()) {
            this.position = newPosition;
        }


    }

    public Position getNewPosition(Position position, int incX, int incY) {
        Position newPosition = new Position(this.getPosition().getX() + incX, this.position.getY() + incY);
        return newPosition;
    }

}