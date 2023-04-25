package com.gildedrose.services;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.ItemFactory;
import com.gildedrose.domain.SpecializedItem;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseRefactored {
    private final List<SpecializedItem> items;

    public GildedRoseRefactored(List<Item> items) {
        this.items = new ArrayList<>();
        for (Item item : items) {
            this.items.add(ItemFactory.createSpecializedItem(item));
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).updateItem();
        }
    }

    public List<SpecializedItem> getItems() {
        return items;
    }
}
