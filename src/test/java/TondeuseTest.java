import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TondeuseTest {

    private Tondeuse tondeuse1 =new Tondeuse();
    private Tondeuse tondeuse2 =new Tondeuse();
    private String instructions1 = "GAGAGAGAA";
    private String instructions2 = "AADAADADDA";
    private char [] moves1 = instructions1.toCharArray();
    private char [] moves2 = instructions2.toCharArray();

    /*
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
    public void setUp(){
        tondeuse1.setX(1);
        tondeuse1.setY(2);
        tondeuse1.setOrientation('N');


        tondeuse2.setX(3);
        tondeuse2.setY(3);
        tondeuse2.setOrientation('E');

    }

    @Test
    public void testTondeuse(){
        Tondeuse.xMAX=5;
        Tondeuse.yMAX=5;

        for(int i =0; i< moves1.length; i++ ){
            tondeuse1.move(moves1[i]);
        }

        for(int i =0; i< moves2.length; i++ ){
            tondeuse2.move(moves2[i]);
        }

        assertThat(tondeuse1.getX()).isEqualTo(1);
        assertThat(tondeuse1.getY()).isEqualTo(3);
        assertThat(tondeuse1.getOrientation()).isEqualTo('N');

        assertThat(tondeuse2.getX()).isEqualTo(5);
        assertThat(tondeuse2.getY()).isEqualTo(1);
        assertThat(tondeuse2.getOrientation()).isEqualTo('E');
               
    }
}
