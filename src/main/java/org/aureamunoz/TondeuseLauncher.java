package org.aureamunoz;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.aureamunoz.model.Action;
import org.aureamunoz.model.Direction;
import org.aureamunoz.model.Position;
import org.aureamunoz.model.Tondeuse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TondeuseLauncher {

    public static void main(String[] args) {

        BufferedReader br = null;
        int tondeuseCounter = 0;

        try {

            FileReader reader = new FileReader("src/main/resources/instructions.txt");
            br = new BufferedReader(reader);
            String maxPos = br.readLine();

            initLimitsOfGrass(maxPos);

            String line = br.readLine();
            while (line != null) {
                tondeuseCounter++;
                System.out.println("****************** org.aureamunoz.model.Tondeuse " + tondeuseCounter + " ******************");
                if (isTondeuseInitialPositionValid(line)) {

                    Tondeuse tondeuse = new Tondeuse(Character.getNumericValue(line.charAt(0)), Character.getNumericValue(line.charAt(1)), Direction.getDirectionfromName(line.charAt(2)));
                    System.out.println(" Depart: " + tondeuse.getPositionForPrint() + tondeuse.getDirection());

                    String instructions = br.readLine();
                    if (areInstructionsValidForTondeuse(instructions)) {
                        tondeuse.move(instructions);
                        System.out.println(" Arrivée: " + tondeuse.getPositionForPrint() + tondeuse.getDirection());
                    }


                }
                else {
                    //next line
                    br.readLine();
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
        }


    }


    private static boolean areInstructionsValidForTondeuse(String instructionsTondeuse) {
        if (StringUtils.isNotEmpty(instructionsTondeuse)) {
            Tondeuse.format(instructionsTondeuse);
            try {
                for (char mv : instructionsTondeuse.toCharArray()) {
                    Action.getActionfromName(mv);
                }
            } catch (AssertionError e) {
                System.out.println(" Instructions pour tondeuse incorrect : " + e.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }

    private static void initLimitsOfGrass(String maxPos) {
        if (StringUtils.isNotEmpty(maxPos)) {
            if (maxPos.length() != 2) {
                Position.xMAX = 5;
                Position.yMAX = 5;
                System.out.println(" Initialisation par défaut : (5,5)");
            } else if (!Character.isDigit(maxPos.charAt(0)) || !Character.isDigit(maxPos.charAt(1))) {
                Position.xMAX = 5;
                Position.yMAX = 5;
                System.out.println(" Initialisation par défaut : (5,5)");
            } else if (maxPos.charAt(0) <= 0 || maxPos.charAt(1) <= 0) {
                Position.xMAX = 5;
                Position.yMAX = 5;
                System.out.println(" Initialisation par défaut : (5,5)");

            } else {
                Position.xMAX = maxPos.charAt(0);
                Position.yMAX = maxPos.charAt(1);
            }
        }
    }

    private static boolean isTondeuseInitialPositionValid(String initTondeuse) {
        if (StringUtils.isNotEmpty(initTondeuse)) {
            if (initTondeuse.length() != 3) {
                System.out.println(" Initialization tondeuse impossible avec cette ligne : '" + initTondeuse + "'");
                return false;
            } else if (!Character.isDigit(initTondeuse.charAt(0)) || !Character.isDigit(initTondeuse.charAt(1)) || !Character.isLetter(initTondeuse.charAt(2))) {
                System.out.println(" Initialization tondeuse impossible avec cette ligne : '" + initTondeuse + "'");
                return false;
            } else {
                Position positionTondeuse = new Position(Character.getNumericValue(initTondeuse.charAt(0)), Character.getNumericValue(initTondeuse.charAt(1)));
                if (Boolean.FALSE.equals(positionTondeuse.isValid())) {
                    System.out.println(" Initialization tondeuse impossible avec cette ligne : position initiale incorrecte (" + initTondeuse.charAt(0) + "," + initTondeuse.charAt(1) + ")");
                    return false;
                }
                try {
                    Direction.getDirectionfromName(initTondeuse.charAt(2));
                } catch (AssertionError e) {
                    System.out.println(" Initialization tondeuse impossible avec cette ligne : orientation incorrecte : " + e.getLocalizedMessage());
                    return false;
                }
            }
            return true;
        }
        return false;
    }


}

