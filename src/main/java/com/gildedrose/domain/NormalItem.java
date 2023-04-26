package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MINIMUM_ITEM_QUALITY;

public class NormalItem extends Item implements Updatable {

    public NormalItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void update() {
        this.sellIn--;
        if (this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality--;
        }

        if (this.sellIn < 0 && this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality--;
        }
    }
}
