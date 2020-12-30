/*
*--------Title: Grumpy Bookstore Owner---------
* Programmer: Cameron Cowan
* Class: Data Structures & Algorithms
* Professor: James Iannibelli
* Date: 11/15/2020
* Team: Team A
* Version: 0.5
*
* Description: This program solves the Grumpy Bookstore Owner Problem w/ different algorithms:
*
* Today, the bookstore owner has a store open for customers.length minutes.
* Every minute, some number of customers (customers[i]) enter the store, and all
* those customers leave after the end of that minute. On some minutes, the bookstore
* owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1,
* otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that
* minute are not satisfied, otherwise they are satisfied. The bookstore owner knows a
* secret technique to keep themselves not grumpy for X minutes straight, but can only
* use it once. Return the maximum number of customers that can be satisfied throughout the day
*
* */


package DataStructuresAlgorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("config.txt"));
        } catch (FileNotFoundException var23) {
            System.out.println("Configuration file \"config.txt\" not found");
        } catch (IOException var24) {
            System.out.println("Something is wrong with configuration file \"config.txt\"");
        }


        int NUMBER_OF_MINUTES = Integer.parseInt(properties.getProperty("NumberOfMinutes"));
        int MAX_NUMBER_OF_CUSTOMERS = Integer.parseInt(properties.getProperty("MaxNumberOfCustomers"));
        int NON_GRUMPY_WINDOW_LENGTH = Integer.parseInt(properties.getProperty("NonGrumpyWindowLength"));
        //Start Total Run Time
        long startTimeIns = System.nanoTime();

        //Introduction
        System.out.println("======================================================================");
        System.out.println("The Grumpy Bookstore Owner:\n");
        System.out.println("Developed by: ");
        String[] Team = {" Katherine Leo: Project Manager,", " Cameron Cowan: Lead Programmer,", " Lingrong Hu: Program Architect,", " Leah Sugar: Technical Analyst,", " Douglas Tisdale: Program Tester,", " Erik Midtskogen: Technical Writer"};

        for (int i = 0; i < Team.length; i++) {
            System.out.println(Team[i]);
        }

        System.out.println("======================================================================");


        //New Customer and Store Owner
        Grumpy storeOwner = new Grumpy(NUMBER_OF_MINUTES);
        Customer storeCustomer = new Customer(NUMBER_OF_MINUTES, MAX_NUMBER_OF_CUSTOMERS);
        new Satisfaction(NUMBER_OF_MINUTES);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Select Method for Creating Database (Customer Satisfaction): \n1. Randomized Input; \n2. Input from config.txt");
        int userSelectionCustomer = sc.nextInt();

        //Create New Arrays
        System.out.println("\nTimes when business owner is Grumpy:");
        int[] grumpyArray = storeOwner.grumpyArray();
        int[] customerArray;

        //User Generate Customer Array
        //System.out.println("\nPlease Select Method for Creating Database (Customer Satisfaction): " +
                //"\n1. Manual Customer Satisfaction  \n2. Randomized Customer Satisfaction ");

        //Select input of user for customer array
        switch (userSelectionCustomer){
            case 1:
                customerArray = storeCustomer.randomCustomerArray();
                grumpyArray = storeOwner.randomGrumpyArray();
                break;
                //System.out.println("\nCustomer Satisfaction:");
                //customerArray = storeCustomer.customerUserInputArray();
                //break;
            default:
                customerArray = storeCustomer.configuredCustomerArray();
                grumpyArray = storeOwner.configuredGrumpyArray();
                //System.out.println("\nCustomer Satisfaction:");
                //customerArray = storeCustomer.customerArray();
                break;
        }



        //Select user Algorithm:
        System.out.println("Customers per Minute:");
        Satisfaction.printArray(customerArray);
        System.out.println("Grumpy Status per Minute:");
        Satisfaction.printArray(grumpyArray);
        System.out.println("Non-Grumpy Window Length: " + NON_GRUMPY_WINDOW_LENGTH);
        int algorithmSelection = 0;

        while(algorithmSelection < 4) {
            System.out.println("\nPlease Select An Algorithm: \n1. Brute Force  \n2. Sliding Window \n3. Prefix Sum \n4. Exit Program ");
            algorithmSelection = sc.nextInt();
            switch(algorithmSelection) {
                case 1:
                    BruteForce algo1 = new BruteForce();
                    System.out.println("Max Sum (BruteForce): " + algo1.maxSatisfied(customerArray, grumpyArray, NON_GRUMPY_WINDOW_LENGTH));
                    break;
                case 2:
                    SlidingWindow algo2 = new SlidingWindow();
                    System.out.println("Max Sum (SlidingWindow): " + algo2.maxSatisfied(customerArray, grumpyArray, NON_GRUMPY_WINDOW_LENGTH));
                    break;
                case 3:
                    PrefixSum algo3 = new PrefixSum();
                    System.out.println("Max Sum (PrefixSum): " + algo3.maxSatisfied(customerArray, grumpyArray, NON_GRUMPY_WINDOW_LENGTH));
                    break;
                default:
                    System.out.println("Exiting...");
                    long endTime = System.nanoTime();
                    long duration = endTime - startTimeIns;
                    System.out.println("Total Runtime (nanoseconds): " + duration);
            }
        }
    }
}
