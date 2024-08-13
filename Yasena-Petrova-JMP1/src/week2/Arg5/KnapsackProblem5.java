package week2.Arg5;
import java.util.ArrayList;
import java.util.List;

public class KnapsackProblem5 {
    static class Item {
        int volume;
        int value;

        public Item(int volume, int value) {
            this.volume = volume;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int capacity = 10; // обем на куфара
        List<Item> items = new ArrayList<>(); // предмети

        // Добавяне на предмети
        items.add(new Item(2, 6));
        items.add(new Item(2, 10));
        items.add(new Item(3, 12));

        // Решаване на задачата
        List<Item> selectedItems = knapsack(items, capacity);

        // Отпечатване на избраните предмети
        System.out.println("Избрани предмети:");
        for (Item item : selectedItems) {
            System.out.println("Обем: " + item.volume + ", Стойност: " + item.value);
        }
    }

    public static List<Item> knapsack(List<Item> items, int capacity) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];

        // Изчисляване на максималната стойност
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (items.get(i - 1).volume <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items.get(i - 1).volume] + items.get(i - 1).value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Определяне на избраните предмети
        List<Item> selectedItems = new ArrayList<>();
        int i = n;
        int j = capacity;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems.add(items.get(i - 1));
                j -= items.get(i - 1).volume;
            }
            i--;
        }

        return selectedItems;
    }
}
