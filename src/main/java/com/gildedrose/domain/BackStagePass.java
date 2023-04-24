package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MAXIMUM_ITEM_QUALITY;
import static com.gildedrose.domain.ItemConfig.MINIMUM_ITEM_QUALITY;

public class BackStagePass extends Item implements SpecializedItem {
    public BackStagePass(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public void updateItem() {
        this.sellIn--;

        if (this.quality < MAXIMUM_ITEM_QUALITY) {
            this.quality++;
        }

        if (this.sellIn < 10 && this.quality < MAXIMUM_ITEM_QUALITY) {
            this.quality++;
        }

        if (this.sellIn < 5 && this.quality < MAXIMUM_ITEM_QUALITY) {
            this.quality++;
        }

        if (this.sellIn < 0) {
            this.quality = MINIMUM_ITEM_QUALITY;
        }
    }
}
