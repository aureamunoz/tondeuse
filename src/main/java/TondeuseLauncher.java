import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

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

            //Set the max coordinates of the grass
            int maxX = 5;
            int maxY = 5;

            if (StringUtils.isNotEmpty(maxPos)) {
                maxX = Character.getNumericValue(maxPos.charAt(0));
                maxY = Character.getNumericValue(maxPos.charAt(1));
            }
            String line = br.readLine();
            while (line != null) {
                tondeuseCounter++;
                System.out.println("****************** Tondeuse " + tondeuseCounter + " ******************");
                System.out.println(" Depart: " + line);

                Tondeuse tondeuse = new Tondeuse(maxX, maxY);
                tondeuse.setX(Character.getNumericValue(line.charAt(0)));
                tondeuse.setY(Character.getNumericValue(line.charAt(1)));
                tondeuse.setOrientation(line.charAt(2));
                String moves = br.readLine();

                for (int i = 0; i < moves.length(); i++) {
                    tondeuse.move(moves.charAt(i));
                }
                System.out.println(" Arrivée: " + tondeuse.getX() + tondeuse.getY() + tondeuse.getOrientation());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
        }


    }


}

