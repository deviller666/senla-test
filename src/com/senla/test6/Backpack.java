package com.senla.test6;

import java.util.ArrayList;

public class Backpack {

    public int capacity;
    public ArrayList<BackpackItem> items;

    Backpack(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public int getCurrentCost() {
        return items.stream().mapToInt(i -> i.cost).sum();
    }

    public void fillWithMaxPrice(BackpackItem[] availableItems) {
        int[][] matrix = new int[availableItems.length + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i <= availableItems.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (availableItems[i - 1].weight > j) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    matrix[i][j] = Math.max(
                            matrix[i - 1][j],
                            matrix[i - 1][j - availableItems[i - 1].weight] + availableItems[i - 1].cost
                    );
                }
            }
        }

        int remainingCost = matrix[availableItems.length][capacity];
        int remainingCapacity = capacity;

        for (int i = availableItems.length; i > 0 && remainingCost > 0; i--) {
            if (remainingCost != matrix[i-1][remainingCapacity]) {
                items.add(availableItems[i-1]);
                remainingCost -= availableItems[i-1].cost;
                remainingCapacity -= availableItems[i-1].weight;
            }
        }
    }

    public static class BackpackItem {

        public String title;
        public int weight;
        public int cost;

        BackpackItem(String title, int weight, int cost) {
            this.title = title;
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("%s (weight: %d, cost: %d)", title, weight, cost);
        }
    }

}
