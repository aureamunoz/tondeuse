import org.junit.Before;
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


    @Before
    public void setUp() {
        tondeuse = new Tondeuse(5,5);


    }

    @Test
    public void testTondeuse1() {
        String instructions1 = "GAGAGAGAA";
        tondeuse.setX(1);
        tondeuse.setY(2);
        tondeuse.setOrientation('N');

        tondeuse.move(instructions1);

        assertThat(tondeuse.getX()).isEqualTo(1);
        assertThat(tondeuse.getY()).isEqualTo(3);
        assertThat(tondeuse.getOrientation()).isEqualTo('N');


    }

    @Test
    public void testTondeuse2() {

        String instructions2 = "AADAADADDA";
        tondeuse.setX(3);
        tondeuse.setY(3);
        tondeuse.setOrientation('E');

        tondeuse.move(instructions2);

        assertThat(tondeuse.getX()).isEqualTo(5);
        assertThat(tondeuse.getY()).isEqualTo(1);
        assertThat(tondeuse.getOrientation()).isEqualTo('E');

    }
}
