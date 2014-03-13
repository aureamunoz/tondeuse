

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
            for (String mv : toStringArray(instructions)) {
                move(Action.valueOf(mv));
            }
        }
    }

    //TODO probar con Optional

    private String[] toStringArray(String word) {
        if (StringUtils.isNotEmpty(word)) {
            String[] strArray = word.split("");
//            String[] strArray = new String[]{word};
            return strArray;
        }
        return null;

    }

    public void move(Action instruction) {
        switch (instruction) {
            case DROITE:
                this.direction.turnRight();
                break;
            case GAUCHE:
                this.direction.turnLeft();
                break;
            case AVANCE:
                goAheadIfPossible();
                break;
        }

    }


    private void goAheadIfPossible() {
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

    public Position getNewPosition(Position position, int nbX, int nbY) {
        Position newPosition = new Position(this.getPosition().getX() + nbX, this.position.getY() + nbY);
        return newPosition;
    }

}