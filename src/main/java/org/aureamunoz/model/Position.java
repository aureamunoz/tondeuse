package org.aureamunoz.model;

import com.google.common.base.Objects;

public class Position {

    private int x;
    private int y;

    public static int xMAX;
    public static int yMAX;

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



    public Position(int x, int y, int xMAX, int yMAX) {
        this.x = x;
        this.y = y;
        this.xMAX = xMAX;
        this.yMAX = yMAX;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass() )
            return false;
        Position p = (Position) o;
        return Objects.equal(this.x, p.x)&& Objects.equal(this.y,p.y);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.x,this.y);
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
