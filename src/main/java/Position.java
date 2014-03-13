public class Position {

    private int x;
    private int y;

    public int xMAX;
    public int yMAX;

    public static final int X_MIN = 0;
    public static final int Y_MIN = 0;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getyMAX() {
        return yMAX;
    }

    public void setyMAX(int yMAX) {
        this.yMAX = yMAX;
    }

    public int getxMAX() {
        return xMAX;
    }

    public void setxMAX(int xMAX) {
        this.xMAX = xMAX;
    }



    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean isValid(){
        if (isValidX() && isValidY()){
            return true;
        }
        return false;
    }

    public boolean isValidX(){
        if (X_MIN <= this.x && this.x <= xMAX){
            return true;
        }
        return false;
    }

    public boolean isValidY(){
        if (Y_MIN <= this.y && this.y <= yMAX){
            return true;
        }
        return false;
    }


}
