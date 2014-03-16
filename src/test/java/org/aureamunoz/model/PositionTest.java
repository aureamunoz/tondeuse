package org.aureamunoz.model;

import org.aureamunoz.model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    static{
        Position.xMAX = 5;
        Position.yMAX = 5;
    }

    @Test
    public void testIsValidX(){
        Position position = new Position(3,7);
        assertThat(position.isValidX()).isTrue();
    }

    @Test
    public void testIsNotValidX(){
        Position position = new Position(9,2);
        assertThat(position.isValid()).isFalse();
    }

    @Test
    public void testIsValidY(){
        Position position = new Position(11,4);
        assertThat(position.isValidY()).isTrue();
    }

    @Test
    public void testIsNotValidY(){
        Position position = new Position(1,9);
        assertThat(position.isValidY()).isFalse();
    }

    @Test
    public void testIsValid(){
        Position position = new Position(3,3);
        assertThat(position.isValid()).isTrue();
    }

    @Test
    public void testIsNotValid(){
        Position position = new Position(9,9);
        assertThat(position.isValid()).isFalse();
    }
}
