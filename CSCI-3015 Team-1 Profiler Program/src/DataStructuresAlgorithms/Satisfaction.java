package DataStructuresAlgorithms;

import java.util.Random;

public class Satisfaction {

    //Creates default array to be used program wide
    public int[] timeOfDay;
    private int numberOfMinutes;

    public Satisfaction(int numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
        this.timeOfDay = new int[numberOfMinutes];
    }

    public void currentDay(){
        int[] var1 = this.timeOfDay;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            int i = var1[var3];
            System.out.println(i);
        }
    }

    //Random Boolean Array
    public boolean[] currentDayBoolean(){
        Random rd = new Random();
        boolean[] arr = new boolean[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextBoolean();
        }
        return arr;
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
