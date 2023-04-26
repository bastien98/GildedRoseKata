package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MAXIMUM_ITEM_QUALITY;

public class AgedBrie extends Item implements Updatable {

    public AgedBrie(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void update() {
        this.sellIn--;
        if (this.quality < MAXIMUM_ITEM_QUALITY) {
            this.quality++;
        }
        if (this.quality < MAXIMUM_ITEM_QUALITY && this.sellIn < 0) {
            this.quality++;
        }
    }
}
