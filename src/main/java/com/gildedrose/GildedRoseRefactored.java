package com.gildedrose;

import java.util.List;

public class GildedRoseRefactored {
    List<Item> items;

    public GildedRoseRefactored(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.name.equals("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
                if (item.quality < 50 && item.sellIn < 0) {
                    item.quality = item.quality + 1;
                }

            }

            if(item.quality >0 && !item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Aged Brie") ) {
                item.quality = item.quality - 1;
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstage(item);
            }



            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    continue;
                }
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                } else {
                    if (item.quality > 0) {
                        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            continue;
                        }
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }

    private void updateBackstage(final Item item) {
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


}
