package com.gildedrose.domain;

import static com.gildedrose.domain.ItemConfig.MINIMUM_ITEM_QUALITY;

public class ConjuredItem extends Item implements Updatable {

    public ConjuredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    @Override
    public void update() {
        this.sellIn--;
        if (this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality = this.quality - 2;
            if (this.quality < MINIMUM_ITEM_QUALITY) {
                this.quality = 0;
            }
        }

        if (this.sellIn < 0 && this.quality > MINIMUM_ITEM_QUALITY) {
            this.quality = this.quality - 2;
        }
    }
}
