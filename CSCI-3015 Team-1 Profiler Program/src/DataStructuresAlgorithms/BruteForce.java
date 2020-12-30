package DataStructuresAlgorithms;

public class BruteForce {

    public BruteForce() {
    }

    //Bruteforce - Greedy Algorithm
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {


        //Total Run Time
        long startTimeIns = System.nanoTime();

        //int row = 0;
        int numberOfCompareOperations = 0;
        int numberOfArithmeticOperations = 0;
        int maxSatisfaction = -2147483648;
        int start = 0;
        //int end = start + X - 1;

        //Keep track of length of given array
        for(int end = start + X - 1; end < customers.length; ++end) {
            //Total Satisfied Customers
            int currentSatisfied = 0;
            //Iterate through each value of our Grumpy array to determine our total sum
            for(int i = 0; i < customers.length; ++i) {
                ++numberOfCompareOperations;
                if (grumpy[i] == 0 || i >= start && i <= end) {
                    currentSatisfied += customers[i];
                    ++numberOfArithmeticOperations;
                }
            }
            //Test satisfaction:
            maxSatisfaction = Math.max(currentSatisfied,maxSatisfaction);
            start++;
            end++;
        }

        //Return RunTime:
        long endTime = System.nanoTime();
        long duration = ((endTime - startTimeIns));
        System.out.println("\n======================================================================");
        System.out.println("\nBrute Force Algorithm Total Runtime (nanoseconds): " + duration);
        System.out.println("\n======================================================================");



        return maxSatisfaction;
    }
}
