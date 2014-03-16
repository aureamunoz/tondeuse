package org.aureamunoz.model;

import org.aureamunoz.model.Direction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void testTurnRight(){
        for(Direction direction :Direction.values()){
            switch (direction){
                case NORTH:
                    assertThat(direction.turnRight()).isEqualTo(Direction.EAST);
                    break;
                case EAST:
                    assertThat(direction.turnRight()).isEqualTo(Direction.SOUTH);
                    break;
                case SOUTH:
                    assertThat(direction.turnRight()).isEqualTo(Direction.WEST);
                    break;
                case WEST:
                    assertThat(direction.turnRight()).isEqualTo(Direction.NORTH);
                    break;
            }
        }
    }

    @Test
    public void testTurnLeft(){
        for(Direction direction :Direction.values()){
            switch (direction){
                case NORTH:
                    assertThat(direction.turnLeft()).isEqualTo(Direction.WEST);
                    break;
                case EAST:
                    assertThat(direction.turnLeft()).isEqualTo(Direction.NORTH);
                    break;
                case SOUTH:
                    assertThat(direction.turnLeft()).isEqualTo(Direction.EAST);
                    break;
                case WEST:
                    assertThat(direction.turnLeft()).isEqualTo(Direction.SOUTH);
                    break;
            }
        }
    }

    @Test
    public void testValidsActions(){
        String dirs = "NSWES";
        for(char character: dirs.toCharArray()){
            Direction enumDirection = Direction.getDirectionfromName(character);
            assertThat(enumDirection.name()).isNotEmpty();
        }

    }

    @Test(expected = AssertionError.class)
    public void testInvalidsActions(){
        String dirs = "zagbn";
        for(char character: dirs.toCharArray()){
            Direction enumDirection = Direction.getDirectionfromName(character);
        }

    }
}
