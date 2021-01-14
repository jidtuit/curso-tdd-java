package com.gildedrose.decorators;

import com.gildedrose.Item;

public class RegularItemDecorator extends ItemDecorator{

  public RegularItemDecorator(Item item) {
    super(item);
  }

  @Override
  public void updateItem() {
    int sellIn = item.sellIn;
    int quality = item.quality;

    sellIn--;
    if (sellIn < 0) {
      quality -= 2;
    } else {
      quality--;
    }
    quality = validateQuality(quality);

    item.sellIn = sellIn;
    item.quality = quality;
  }

}
