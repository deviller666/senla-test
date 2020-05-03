package com.senla.test6;

import com.senla.utils.InputUtils;
import com.senla.utils.StringUtils;

import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int backpackCapacity;
        try {
            backpackCapacity = InputUtils.readNumberFromStdIn("Enter your backpack capacity: ");
        } catch (InputMismatchException e) {
            System.out.println("Your input is not a number");
            return;
        }

        String rawItemsString;
        rawItemsString = InputUtils.readSentenceFromStdIn("Enter your items. Format is <String title>;<int weight>;<int cost> with space delimiter," +
                " e.g sword;10;2 hat;5;10: ");

        String[] rawItems = StringUtils.getWords(rawItemsString);
        Backpack.BackpackItem[] items = new Backpack.BackpackItem[rawItems.length];
        for (int i = 0; i < rawItems.length; i += 1) {
            String[] rawItemParts = rawItems[i].split(";");
            if (rawItemParts.length < 3) {
                System.out.printf("Your items %s is not properly formatted\n", rawItems[i]);
                return;
            }

            String itemTitle = rawItemParts[0];
            int itemWeight, itemCost;
            try {
                itemWeight = Integer.parseInt(rawItemParts[1]);
                itemCost = Integer.parseInt(rawItemParts[2]);
            } catch (NumberFormatException e) {
                System.out.printf("Your items %s is not properly formatted\n", rawItems[i]);
                return;
            }
            items[i] = new Backpack.BackpackItem(itemTitle, itemWeight, itemCost);
        }

        Backpack backpack = new Backpack(backpackCapacity);
        backpack.fillWithMaxPrice(items);

        System.out.printf("Your best fit with max cost %d is: %s\n",
                backpack.getCurrentCost(),
                backpack.items.stream()
                        .map(Backpack.BackpackItem::toString)
                        .collect(Collectors.joining(", ")));
    }

}
