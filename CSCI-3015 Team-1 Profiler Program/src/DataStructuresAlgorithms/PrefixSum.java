package DataStructuresAlgorithms;

public class PrefixSum {

    //Prefix Sum Algorithm - Parallel Prefix
    public int maxSatisfiedOriginal(int[] customers, int[] grumpy, int X) {

        //Total Run Time
        long startTimeIns = System.nanoTime();

        int answer = 0;
        int max = -1;
        int n = customers.length;
        int[] prefix = new int[n+1];
        int startMax = 0, endMax = 0;
        // Calculate prefix sum of the customers who were unsatisfied
        for(int i=1; i<= n; i++) {
            prefix[i] = prefix[i-1] + (grumpy[i-1] == 0 ? 0 : customers[i-1]);
        }

        // Find the window of X length having the most unsatisfied customers
        for(int start = 0; start <= n-X; start++) {
            int end = start + X;
            if(prefix[end] - prefix[start] >= max) {
                startMax = start;
                endMax = end;
                max = prefix[end] - prefix[start];
            }
        }

        // Add all satisfied customers and the X customers
        for(int i=0; i<n; i++) {
            if(grumpy[i] == 0 || (i >= startMax && i < endMax)) {
                answer += customers[i];
            }
        }

        //Return RunTime:
        long endTime = System.nanoTime();
        long duration = ((endTime - startTimeIns));
        System.out.println("\n======================================================================");
        System.out.println("\nPrefix Sum Algorithm Total Runtime (nanoseconds): " + duration);
        System.out.println("\n======================================================================");


        return answer;
    }

    //Alternative Prefix Sum - Doesn't Work!
    //Issue: Sum too large for final output.
    public int maxSatisfied(int[] customers, int[] grumpy,int X) {

        //Total Run Time
        long startTimeIns = System.nanoTime();

        int numberOfCompareOperations = 0;
        int numberOfArithmeticOperations = 0;
        int answer = 0;
        int max = -1;
        int n = customers.length;
        int[] prefix = new int[n + 1];
        int startMax = 0;
        int endMax = 0;

        int i;
        for(i = 1; i <= n; ++i) {
            ++numberOfArithmeticOperations;
            prefix[i] = prefix[i - 1] + (grumpy[i - 1] == 0 ? 0 : customers[i - 1]);
        }

        for(i = 0; i <= n - X; ++i) {
            int end = i + X;
            ++numberOfCompareOperations;
            if (prefix[end] - prefix[i] >= max) {
                startMax = i;
                endMax = end;
                ++numberOfArithmeticOperations;
                max = prefix[end] - prefix[i];
            }
        }

        for(i = 0; i < n; ++i) {
            ++numberOfCompareOperations;
            if (grumpy[i] == 0 || i >= startMax && i < endMax) {
                ++numberOfArithmeticOperations;
                answer += customers[i];
            }
        }

        //Return RunTime:
        long endTime = System.nanoTime();
        long duration = endTime - startTimeIns;
        System.out.println("\n======================================================================");
        System.out.println("Prefix Sum Algorithm Total Runtime (nanoseconds): " + duration);
        System.out.println("Number of comparison operations: " + numberOfCompareOperations);
        System.out.println("Number of arithmetic operations: " + numberOfArithmeticOperations);
        System.out.println("======================================================================");
        return answer;
    }

}
