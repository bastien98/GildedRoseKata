package com.gildedrose.domain;


import static com.gildedrose.domain.ItemConfig.MAXIMUM_ITEM_QUALITY;
import static com.gildedrose.domain.ItemConfig.MINIMUM_ITEM_QUALITY;

public class BackStagePass extends Item implements SpecializedItem {

    public BackStagePass(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void updateItem() {
        this.sellIn = this.sellIn - 1;
        if (this.quality < MAXIMUM_ITEM_QUALITY) {
            this.quality = this.quality + 1;
        }

        if (this.sellIn < 10) {
            if (this.quality < MAXIMUM_ITEM_QUALITY) {
                this.quality = this.quality + 1;
            }
        }

        if (this.sellIn < 5) {
            if (this.quality < MAXIMUM_ITEM_QUALITY) {
                this.quality = this.quality + 1;
            }
        }

        if (this.sellIn < 0) {
            this.quality = MINIMUM_ITEM_QUALITY;
        }
    }
}
