package com.gildedrose;

import com.gildedrose.domain.Item;
import com.gildedrose.services.GildedRose;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateGoldenMasterFile {
    public static String FILENAME = "src/test/resources/goldenmaster.txt";
    public static void main(String[] args) throws IOException {
        File goldenMasterFile = new File(FILENAME);
        FileWriter fileWriter = new FileWriter(goldenMasterFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("OMGHAI!");

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 11, 20), //
                new Item("Aged Brie", 3, 0), //
                new Item("Elixir of the Mongoose", 6, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 1, 80), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 16, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49),
                new Item("Test Item", 5, 49)
                // this conjured item does not work properly yet
//                new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

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
