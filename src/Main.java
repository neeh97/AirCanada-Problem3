import java.util.*;

public class Main {

    public static void main(String [] args) {
        System.out.println("Enter the number of spins");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> slots = new ArrayList<>();
        for (int i=0; i<n; i++) {
            System.out.println("Enter the slot number");
            slots.add(scanner.next());
        }
        System.out.println("The number of spins is "+countSpins(n, slots));
    }

    public static int countSpins(Integer n, List<String> slots) {
        int numberOfSpins = 0;
        int [][] slotsTable = getSortedTable(slots);

        //This block adds the maximum value in each column starting from the last column because the array is sorted in descending order
        for (int j=slots.get(0).length()-1; j >= 0; j--) {
            int max = 0;
            for (int i=0; i<slots.size(); i++) {
                if (slotsTable[i][j] > max) {
                    max = slotsTable[i][j];
                }
            }
            numberOfSpins += max;
        }
        return numberOfSpins;
    }

    //Returns a 2D array from the input list where the rows are sorted
    public static int[][] getSortedTable(List<String> slots) {
        int [][] slotsTable = new int[slots.size()][slots.get(0).length()];
        for (int i=0; i<slots.size(); i++) {
            String row = slots.get(i);
            for (int j=0; j<row.length(); j++) {
                slotsTable[i][j] = slots.get(i).charAt(j) - '0';
            }
        }

        for (int[] ints : slotsTable) {
            Arrays.sort(ints);
        }
        return slotsTable;
    }

}
