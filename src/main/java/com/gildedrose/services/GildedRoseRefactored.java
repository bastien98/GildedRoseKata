package com.gildedrose.services;

import com.gildedrose.domain.Item;
import com.gildedrose.domain.UpdatableItemFactory;
import com.gildedrose.domain.UpdatableItem;

import java.util.ArrayList;
import java.util.List;

public class GildedRoseRefactored {
    private final List<UpdatableItem> items;

    public GildedRoseRefactored(List<Item> items) {
        this.items = new ArrayList<>();
        for (Item item : items) {
            this.items.add(UpdatableItemFactory.create(item));
        }
    }

    public void updateItems() {
        for (UpdatableItem item : items) {
            item.update();
        }
    }

    public List<UpdatableItem> getItems() {
        return items;
    }
}
