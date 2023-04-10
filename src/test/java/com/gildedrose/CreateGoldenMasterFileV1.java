package com.gildedrose;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateGoldenMasterFileV1 {
    public static String FILENAME = "src/test/resources/goldenmasterV1.txt";
    public static void main(String[] args) throws IOException {
        File goldenMasterV1File = new File(FILENAME);
        FileWriter fileWriter = new FileWriter(goldenMasterV1File);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("OMGHAI!");

        List<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 11, 20));
        items.add(new Item("Aged Brie", 3, 0));
        items.add(new Item("Elixir of the Mongoose", 6, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 16, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49));
        items.add(new Item("Test Item", 5, 49));

        GildedRoseRefactored app = new GildedRoseRefactored(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            printWriter.println("-------- day " + i + " --------");
            printWriter.println("name, sellIn, quality");
            for (Item item : items) {
                printWriter.println(item);
            }
            printWriter.println();
            app.updateQuality();
        }
        printWriter.close();
    }
}
