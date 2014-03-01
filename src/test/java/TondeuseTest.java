import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TondeuseTest {


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


    }

    @Test
    public void testTondeuse1() {
        Tondeuse tondeuse1 = new Tondeuse(5, 5);
        String instructions1 = "GAGAGAGAA";
        char[] moves1 = instructions1.toCharArray();
        tondeuse1.setX(1);
        tondeuse1.setY(2);
        tondeuse1.setOrientation('N');

        for (int i = 0; i < moves1.length; i++) {
            tondeuse1.move(moves1[i]);
        }

        assertThat(tondeuse1.getX()).isEqualTo(1);
        assertThat(tondeuse1.getY()).isEqualTo(3);
        assertThat(tondeuse1.getOrientation()).isEqualTo('N');


    }

    @Test
    public void testTondeuse2() {

        Tondeuse tondeuse2 = new Tondeuse(5, 5);
        String instructions2 = "AADAADADDA";
        char[] moves2 = instructions2.toCharArray();
        tondeuse2.setX(3);
        tondeuse2.setY(3);
        tondeuse2.setOrientation('E');


        for (int i = 0; i < moves2.length; i++) {
            tondeuse2.move(moves2[i]);
        }

        assertThat(tondeuse2.getX()).isEqualTo(5);
        assertThat(tondeuse2.getY()).isEqualTo(1);
        assertThat(tondeuse2.getOrientation()).isEqualTo('E');

    }
}
