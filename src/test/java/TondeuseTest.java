import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TondeuseTest {

    private Tondeuse tondeuse ;


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
        tondeuse = new Tondeuse(1,2,"NORTH");
        tondeuse.getPosition().setxMAX(5);
        tondeuse.getPosition().setyMAX(5);

        tondeuse.move(instructions1);

        assertThat(tondeuse.getPosition().getX()).isEqualTo(1);
        assertThat(tondeuse.getPosition().getY()).isEqualTo(3);
        assertThat(tondeuse.getDirection()).isEqualTo(Direction.NORTH);


    }

//    @Test
//    public void testTondeuse2() {
//
//        String instructions2 = "AADAADADDA";
//        tondeuse.setX(3);
//        tondeuse.setY(3);
//        tondeuse.setDirection('E');
//
//        tondeuse.move(instructions2);
//
//        assertThat(tondeuse.getX()).isEqualTo(5);
//        assertThat(tondeuse.getY()).isEqualTo(1);
//        assertThat(tondeuse.getDirection()).isEqualTo('E');
//
//    }
}
