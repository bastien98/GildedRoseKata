package com.gildedrose.domain;

public class UpdatableItemFactory {
    public static Updatable createUpdatableItem(Item item) {

        if (isBackStageItem(item.name)) {
            return new BackStagePass(item);
        }
        if (ItemConfig.ITEM_TYPE_AGED_BRIE.equals(item.name)) {
            return new AgedBrie(item);
        }
        if (ItemConfig.ITEM_TYPE_SULFURAS.equals(item.name)) {
            return new Sulfuras(item);
        }
        if (isConjuredItem(item.name)) {
            return new ConjuredItem(item);
        }
        return new NormalItem(item);
    }

    private static boolean isBackStageItem(String itemName) {
        return itemName.startsWith(ItemConfig.ITEM_TYPE_BACKSTAGE_PASS);
    }

    private static boolean isConjuredItem(String itemName) {
        return itemName.startsWith(ItemConfig.ITEM_TYPE_CONJURED);
    }
}
