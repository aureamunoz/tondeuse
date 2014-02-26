

import com.google.common.base.Objects;

public class Tondeuse {

    private int x;
    private int y;
    private char orientation;
    public int xMAX;
    public int yMAX;
    public static final int X_MIN = 0;
    public static final int Y_MIN = 0;
    public static final char DROITE = 'D';
    public static final char GAUCHE = 'G';
    public static final char AVANCE = 'A';
    public static final char NORTH = 'N';
    public static final char SOUTH = 'S';
    public static final char EAST = 'E';
    public static final char WEST = 'W';

    public Tondeuse(int xMAX, int yMAX) {
        this.xMAX = xMAX;
        this.yMAX = yMAX;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Tondeuse tondeuse = (Tondeuse) obj;

        return Objects.equal(this.x, tondeuse.x) && Objects.equal(this.y, tondeuse.y)
                && Objects.equal(this.orientation, tondeuse.orientation);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, orientation);
    }

    public void move(char instruction) {
        switch (instruction) {
            case DROITE:
                turnRight();
                break;
            case GAUCHE:
                turnLeft();
                break;
            case AVANCE:
                goAhead();
                break;
        }

    }

    private void goAhead() {
        switch (orientation) {
            case NORTH:
                if (y + 1 <= yMAX)
                    y = y + 1;
                break;
            case EAST:
                if (x + 1 <= xMAX)
                    x = x + 1;
                break;
            case SOUTH:
                if (y - 1 >= Y_MIN)
                    y = y - 1;
                break;
            case WEST:
                if (x - 1 >= X_MIN)
                    x = x - 1;
                break;
        }
    }

    private void turnLeft() {
        if (orientation == NORTH){
            orientation = WEST;
            return;
        }
        if (orientation == WEST){
            orientation = SOUTH;
            return;
        }
        if (orientation == SOUTH){
            orientation = EAST;
            return;
        }
        if (orientation == EAST){
            orientation = NORTH;
            return;
        }
    }

    private void turnRight() {
        if (orientation == NORTH){
            orientation = EAST;
            return;
        }
        if (orientation == EAST){
            orientation = SOUTH;
            return;
        }
        if (orientation == SOUTH){
            orientation = WEST;
            return;
        }
        if (orientation == WEST){
            orientation = NORTH;
            return;
        }
    }

}