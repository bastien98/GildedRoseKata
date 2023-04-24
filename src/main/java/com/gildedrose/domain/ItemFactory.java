package com.gildedrose.domain;

public class ItemFactory {
    public static SpecializedItem createItem(Item item) {

        if(isNormalItem(item)) {
            return new NormalItem(item.name, item.sellIn, item.quality);
        }
        if(isBackStageItem(item)) {
            return new BackStagePass(item.name, item.sellIn, item.quality);
        }
        if("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new Sulfuras(item.name, item.sellIn, item.quality);
        }
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrie(item.name, item.sellIn, item.quality);
        }
        else {
            throw new RuntimeException();
        }
    }

    private static boolean isNormalItem(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.name) && !"Aged Brie".equals(item.name) && !isBackStageItem(item);
    }

    private static boolean isBackStageItem(Item item) {
        String subString = "Backstage passes";
        return item.name.contains(subString);
    }
}
