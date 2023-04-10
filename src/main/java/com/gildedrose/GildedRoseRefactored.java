package com.gildedrose;

import java.util.List;

public class GildedRoseRefactored {

    private static final int MINIMUM_ITEM_QUALITY = 0;
    private static final int MAXIMUM_ITEM_QUALITY = 50;

    private final List<Item> items;


    public GildedRoseRefactored(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
                // Do Nothing
            } else {
                item.sellIn = item.sellIn - 1;
                if (isNormalItem(item)) {
                    updateNormalItem(item);
                }
                if ("Aged Brie".equals(item.name)) {
                    udpateAgedBrie(item);
                }
                if (isBackStageItem(item)) {
                    updateBackstage(item);
                }
            }
        }
    }

    private void updateBackstage(Item item) {
        if (item.quality < MAXIMUM_ITEM_QUALITY) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn < 10) {
            if (item.quality < MAXIMUM_ITEM_QUALITY) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 5) {
            if (item.quality < MAXIMUM_ITEM_QUALITY) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 0) {
            item.quality = MINIMUM_ITEM_QUALITY;
        }
    }

    private boolean isNormalItem(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.name) && !"Aged Brie".equals(item.name) && !isBackStageItem(item);
    }

    private void updateNormalItem(Item item) {
        if (item.quality > MINIMUM_ITEM_QUALITY) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 0 && item.quality > MINIMUM_ITEM_QUALITY) {
            item.quality = item.quality - 1;
        }
    }

    private void udpateAgedBrie(Item item) {
        if (item.quality < MAXIMUM_ITEM_QUALITY) {
            item.quality = item.quality + 1;
        }
        if (item.quality < MAXIMUM_ITEM_QUALITY && item.sellIn < 0) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isBackStageItem(Item item) {
        String subString = "Backstage passes";
        return item.name.contains(subString);
    }
}
