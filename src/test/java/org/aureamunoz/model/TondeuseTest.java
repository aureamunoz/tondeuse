package org.aureamunoz.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


public class TondeuseTest {

    private Tondeuse tondeuse;


    /*instrucciones
    5 5

1 2 N

GAGAGAGAA

3 3 E

AADAADADDA

results
1 3 N

5 1 E
     */


    @Before
    public void setUp() {
        Position.xMAX = 5;
        Position.yMAX = 5;


    }


    @Test
    public void testMove() {
        tondeuse = Mockito.spy(new Tondeuse(1, 2,Direction.NORTH));
        for (Action action : Action.values()) {
            tondeuse.move(action);
        }
        verify(tondeuse, atLeastOnce()).turnRight();
        verify(tondeuse, atLeastOnce()).turnLeft();
        verify(tondeuse, atLeastOnce()).goAheadIfPossible();

    }

    @Test
    public void testMoveWithValidInstructions() {
        tondeuse = Mockito.spy(new Tondeuse(1, 2,Direction.NORTH));
        String instructions = "AGG D AA";
        tondeuse.move(instructions);
        verify(tondeuse, atLeast(6)).move((Action) any());


    }

    @Test(expected = AssertionError.class)
    public void testMoveWithInvalidInstructions() {
        tondeuse = new Tondeuse(1, 2,Direction.NORTH);
        String instructions = "any invalid instruction";
        tondeuse.move(instructions);


    }

    @Test
    public void testMoveWithEmptyInstructions() {
        tondeuse = Mockito.spy(new Tondeuse(1, 2, Direction.NORTH));
        String instructions = "";
        tondeuse.move(instructions);
        verify(tondeuse, never()).move((Action) any());

    }

    @Test
    public void testTurnRight() {
        tondeuse = new Tondeuse(1, 2, Direction.NORTH);
        tondeuse.turnRight();
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.EAST);


    }

    @Test
    public void testTurnLeft() {
        tondeuse = new Tondeuse(1, 2, Direction.NORTH);
        tondeuse.turnLeft();
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.WEST);


    }


    @Test
    public void testGoAhead() {
        tondeuse = Mockito.spy(new Tondeuse(1, 5, Direction.SOUTH));

        Position newPosition = Mockito.mock(Position.class);

        doReturn(newPosition).when(tondeuse).getNewPosition(anyInt(), anyInt());

        for (Direction direction : Direction.values()) {
            tondeuse.setDirection(direction);
            tondeuse.goAheadIfPossible();
            switch (direction) {
                case NORTH:
                    verify(tondeuse, atLeastOnce()).getNewPosition(0, 1);
                    break;
                case EAST:
                    verify(tondeuse, atLeastOnce()).getNewPosition(1, 0);
                    break;
                case SOUTH:
                    verify(tondeuse, atLeastOnce()).getNewPosition(0, -1);
                    break;
                case WEST:
                    verify(tondeuse, atLeastOnce()).getNewPosition(-1, 0);
                    break;
            }
        }
        verify(newPosition, atLeast(4)).isValid();
    }

    @Test
    public void testGetNewPosition() {
        tondeuse = new Tondeuse(1, 2, Direction.NORTH);
        Position newPosition = tondeuse.getNewPosition(5, 6);
        assertThat(newPosition.getX()).isEqualTo(6);
        assertThat(newPosition.getY()).isEqualTo(8);


    }


}



