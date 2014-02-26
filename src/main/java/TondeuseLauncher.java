import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TondeuseLauncher {

    public static void main (String [] args) throws IOException {
        File instructions = new File("classpath:resources");

        FileReader reader = new FileReader("src/main/resources/instructions.txt");
        BufferedReader br = new BufferedReader(reader);
        char [] maxCoordinates = br.readLine().toCharArray();

        if (maxCoordinates.length == 2){
            Tondeuse tondeuse1 = new Tondeuse(maxCoordinates[0],maxCoordinates[1]);
            char[] initialPosition = br.readLine().toCharArray();
            tondeuse1.setX(initialPosition[0]);
            tondeuse1.setY(initialPosition[1]);
            tondeuse1.setOrientation(initialPosition[2]);
            char [] moves1 = br.readLine().toCharArray();

            for(int i=0; i<moves1.length; i++){
                tondeuse1.move(moves1[i]);
            }


            System.out.println("X: "+tondeuse1.getX()+" Y: "+tondeuse1.getY()+" orientation: "+tondeuse1.getOrientation());



        }






    }
}
