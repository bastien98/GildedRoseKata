package com.gildedrose.domain;

public class ItemFactory {
    public static SpecializedItem createItem(Item item) {

        if (isNormalItem(item)) {
            return new NormalItem(item.name, item.sellIn, item.quality);
        }
        if (isBackStageItem(item)) {
            return new BackStagePass(item.name, item.sellIn, item.quality);
        }
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrie(item.name, item.sellIn, item.quality);
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new Sulfuras(item.name, item.sellIn, item.quality);
        } else {
            throw new IllegalArgumentException("Unrecognized item type: " + item.name);
        }
    }

    private static boolean isNormalItem(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.name) &&
            !"Aged Brie".equals(item.name) &&
            !isBackStageItem(item);
    }

    private static boolean isBackStageItem(Item item) {
        return item.name.startsWith("Backstage passes");
    }
}
