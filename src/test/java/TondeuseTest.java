import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
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


//    @Before
//    public void setUp() {
//        tondeuse = new Tondeuse(5,5);
//
//
//    }

    @Test
    public void testTondeuse1() {
        String instructions1 = "GAGAGAGAA";
        tondeuse = new Tondeuse(1, 2, "NORTH");
        tondeuse.getPosition().setxMAX(5);
        tondeuse.getPosition().setyMAX(5);

        tondeuse.move(instructions1);

        assertThat(tondeuse.getPosition().getX()).isEqualTo(1);
        assertThat(tondeuse.getPosition().getY()).isEqualTo(3);
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.NORTH);


    }

    @Test
    public void testMove() {
        tondeuse = Mockito.spy(new Tondeuse(1, 2, "NORTH"));
        for(Action action: Action.values()){
            tondeuse.move(action);
        }
        verify(tondeuse, atLeastOnce()).turnRight();
        verify(tondeuse, atLeastOnce()).turnLeft();
        verify(tondeuse, atLeastOnce()).goAheadIfPossible();

    }





    @Test
    public void testGoAhead() {


    }


}
