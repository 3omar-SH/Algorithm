import java.util.Arrays;
import java.util.Scanner;

public class GreedyAlgo {
    public static void main(String[] args) {
        int[] coins = {25,10,5,1};
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }
}
