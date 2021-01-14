package com.gildedrose.decorators;

import com.gildedrose.Item;

public class BackstagePassesItemDecorator extends ItemDecorator {

  public BackstagePassesItemDecorator(Item item) {
    super(item);
  }

  @Override
  public void updateItem() {
    int sellIn = item.sellIn;
    int quality = item.quality;

    sellIn--;
    if (sellIn >= 10) {
      quality++;
    } else if (sellIn >= 5) {
      quality += 2;
    } else if (sellIn > 0) {
      quality += 3;
    } else {
      quality = 0;
    }

    item.sellIn = sellIn;
    item.quality = quality;
  }
}
