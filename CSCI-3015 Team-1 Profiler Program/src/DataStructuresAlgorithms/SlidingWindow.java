package DataStructuresAlgorithms;

public class SlidingWindow {
    public SlidingWindow() {
    }


    //SlidingWindow Algorithm - Dynamic Algorithm
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        //Total Run Time
        long startTimeIns = System.nanoTime();

        int numberOfCompareOperations = 0;
        int numberOfArithmeticOperations = 0;
        int customersSatisfied = 0;
        int currentSum = 0;
        int max = 0;
        int start = 0;


        int end;
        for(end = 0; end < customers.length; ++end) {
            ++numberOfCompareOperations;
            if (grumpy[end] == 0) {
                //Add Customer
                ++numberOfArithmeticOperations;
                customersSatisfied += customers[end];
            }
        }

        //Perform Sliding Window:
        // Let variable of end = our ending window
        for(end = 0; end < customers.length; ++end) {
            ++numberOfCompareOperations;
            if (grumpy[end] == 1) {
                ++numberOfArithmeticOperations;
                currentSum += customers[end];
            }

            if (end - start + 1 >= X) {
                ++numberOfCompareOperations;
                max = Math.max(max, currentSum);
                numberOfArithmeticOperations += 2;
                if (grumpy[start] == 1) {
                    ++numberOfArithmeticOperations;
                    currentSum -= customers[start];
                }

                ++start;
            }
        }


        //Return RunTime:
        long endTime = System.nanoTime();
        long duration = endTime - startTimeIns;
        System.out.println("\n======================================================================");
        System.out.println("Sliding Window Algorithm Total Runtime (nanoseconds): " + duration);
        System.out.println("Number of comparison operations: " + numberOfCompareOperations);
        System.out.println("Number of arithmetic operations: " + numberOfArithmeticOperations);
        System.out.println("======================================================================");
        return customersSatisfied + max;
    }
}
