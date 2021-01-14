package com.gildedrose.decorators;

import com.gildedrose.Item;

public abstract class ItemDecorator {

  protected final Item item;

  protected ItemDecorator(Item item) {
    this.item = item;
  }

  public abstract void updateItem();

  protected int validateQuality(int quality) {
    if (quality > 50) {
      return 50;
    } else if (quality < 0) {
      return 0;
    }
    return quality;
  }

}
