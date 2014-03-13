import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionTest {

    @Test
    public void testAction(){
        Action a = Action.valueOf("A");
//        a.equals(Action.AVANCE);
        assertThat(a).isEqualTo(Action.AVANCE);


    }

}
