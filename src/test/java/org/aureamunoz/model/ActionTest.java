package org.aureamunoz.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ActionTest {

    @Test
    public void testValidsActions(){
        String actions = "DGA";
        for(char character: actions.toCharArray()){
            Action enumAction = Action.getActionfromName(character);
            assertThat(enumAction.name()).isNotEmpty();
        }

    }

    @Test(expected = AssertionError.class)
    public void testInvalidsActions(){
        String actions = "pdY";
        for(char character: actions.toCharArray()){
            Action enumAction = Action.getActionfromName(character);
        }

    }

}
