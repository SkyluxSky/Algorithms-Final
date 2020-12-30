package DataStructuresAlgorithms;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;


public class Customer extends Satisfaction {
    private int maxNumberOfCustomers;

    int[] customerSatisfaction;

    Customer(int numberOfMinutes, int maxNumberOfCustomers){
        //customerSatisfaction = new int[10];
        super(numberOfMinutes);
        this.maxNumberOfCustomers = maxNumberOfCustomers;

    }

    public int[] customerSatisfaction(){
        int[] arr = this.timeOfDay;
        // creating Random object
        Random rd = new Random();

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = rd.nextInt(this.maxNumberOfCustomers + 1);
        }

        //System.out.println("\nCustomer Satisfaction:");
        //printArray(arr);


        return arr;
    }

    //Establish Final Customer Array - (To Change Customer Array, Run a new customerSatisfation Method)
    public int[] randomCustomerArray(){
        int[] arrCustomer = customerSatisfaction();
        printArray(arrCustomer);
        return arrCustomer;
    }


    //User custom Customer Array:
    public int[] configuredCustomerArray() {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("config.txt"));
        } catch (IOException var5) {
            System.out.println("File not found: config.txt");
        }

        String[] customers = properties.getProperty("Customers").split(",", 0);
        int[] output = new int[customers.length];

        for(int i = 0; i < customers.length; ++i) {
            output[i] = Integer.parseInt(customers[i]);
        }

        return output;
    }

}
