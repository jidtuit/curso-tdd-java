package com.gildedrose;

import com.gildedrose.decorators.AgedBrieItemDecorator;
import com.gildedrose.decorators.BackstagePassesItemDecorator;
import com.gildedrose.decorators.ItemDecorator;
import com.gildedrose.decorators.RegularItemDecorator;
import com.gildedrose.decorators.SulfurasItemDecorator;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {

		for (Item item : items) {
			ItemDecorator itemDecorator = itemDecoratorSelector(item);
			itemDecorator.updateItem();
		}

	}

	private ItemDecorator itemDecoratorSelector(Item item) {
		return switch(item.name) {
			case "Aged Brie" -> new AgedBrieItemDecorator(item);
			case "Sulfuras, Hand of Ragnaros" -> new SulfurasItemDecorator(item);
			case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassesItemDecorator(item);
			default -> new RegularItemDecorator(item);
		};
	}
}
