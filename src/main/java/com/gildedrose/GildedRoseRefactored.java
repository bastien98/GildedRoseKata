package com.gildedrose;

import java.util.List;

public class GildedRoseRefactored {


    private final List<Item> items;

    public GildedRoseRefactored(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            switch (item.name) {
                case "Aged Brie":
                    udpateAgedBrie(item);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstage(item);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    // Do Nothing
                    break;

                default:
                    updateDefaultItem(item);

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

    private void updateDefaultItem(Item item) {
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

}
