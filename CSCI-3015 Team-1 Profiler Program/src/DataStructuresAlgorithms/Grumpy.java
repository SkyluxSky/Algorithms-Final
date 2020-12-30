package DataStructuresAlgorithms;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Grumpy extends Satisfaction {

    Grumpy(int numberOfMinutes) {
        super(numberOfMinutes);
    }

    //Create Grumpy Array:
    public int[] randomGrumpyArray(){
        int[] arr = timeOfDay;
        // creating Random object
        Random rd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt(2);
        }

        //System.out.println("\nTimes when business owner is Grumpy:");
        //printArray(arr);

        return arr;
    }

    //Lock-In Grumpy Array - (To Change Grumpy Array, Run a new isGrumpy Method)
    public int[] grumpyArray(){
        int[] arrGrumpy = randomGrumpyArray();
        printArray(arrGrumpy);
        return arrGrumpy;
    }

    public void grumpyPrintArray(){
        System.out.println("\nTimes when business owner is Grumpy:");
    }

    public int[] configuredGrumpyArray() {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("config.txt"));
        } catch (IOException var6) {
            System.out.println("Problem loading config.txt");
        }

        String grumpyTokens = properties.getProperty("Grumpy");
        String[] tokens = grumpyTokens.split(",", 0);
        int[] output = new int[tokens.length];

        for(int i = 0; i < tokens.length; ++i) {
            output[i] = Integer.parseInt(tokens[i]);
        }

        return output;
    }

}
