package com.gildedrose;

import java.util.List;

public class GildedRoseRefactored {
    List<Item> items;

    public GildedRoseRefactored(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (isNormalItem(item)) {
                updateNormalItem(item);
            }

            if (item.name.equals("Aged Brie")) {
                udpateAgedBrie(item);
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(item);
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateSulfuras(item);
            }
        }
    }

    private void updateBackstage(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        if (item.sellIn +1 < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn +1 < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateNormalItem(Item item) {
        item.sellIn = item.sellIn - 1;
        if(item.quality >0) {
            item.quality = item.quality - 1;
        }

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void udpateAgedBrie(Item item) {
        item.sellIn = item.sellIn - 1;
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        if (item.quality < 50 && item.sellIn < 0) {
            item.quality = item.quality + 1;
        }
    }

    private void updateSulfuras(Item item) {
    }

    private boolean isNormalItem(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Aged Brie");
    }


}
