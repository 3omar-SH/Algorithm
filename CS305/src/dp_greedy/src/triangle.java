import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Loop through each row
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // Add 1 at the start of each row
            row.add(1);

            // Fill in the middle values
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }

            // Add 1 at the end of each row if it's not the first row
            if (i > 0) {
                row.add(1);
            }

            // Add the row to the triangle
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> triangle = generate(n);
        System.out.println(triangle);
    }
}
