package com.gildedrose.domain;

public class ItemFactory {
    public static SpecializedItem createSpecializedItem(Item item) {

        if (isBackStageItem(item.name)) {
            return new BackStagePass(item);
        }
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrie(item);
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new Sulfuras(item);
        }
        if (isConjuredItem(item.name)) {
            return new ConjuredItem(item);
        }
         return new NormalItem(item);
    }

    private static boolean isBackStageItem(String itemName) {
        return itemName.startsWith("Backstage passes");
    }

    private static boolean isConjuredItem(String itemName) {
        return itemName.startsWith("Conjured");
    }
}
