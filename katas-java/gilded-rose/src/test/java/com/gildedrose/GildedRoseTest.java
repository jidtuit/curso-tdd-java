package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GildedRoseTest {

  @Test
  void shouldUpdateItemWhenItIsARegularItem() {
    Item[] items = new Item[]{new Item("regularItem", 5, 5)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals("regularItem", actual.name);
    assertEquals(4, actual.sellIn);
    assertEquals(4, actual.quality);
  }

  @Test
  void shouldNotUpdateQualityWhenItIsAlreadyZero() {
    Item[] items = new Item[]{new Item("regularItem", 5, 0)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals(4, actual.sellIn);
    assertEquals(0, actual.quality);
  }

  @Test
  void shouldDoubleDegradeQualityWhenTheSellDateHasPassed() {
    Item[] items = new Item[]{new Item("regularItem", 0, 10)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals(-1, actual.sellIn);
    assertEquals(8, actual.quality);
  }


  @Test
  void shouldUpdateQuality1WhenIsAnAgedBrieWithPositiveSellIn() {
    Item[] items = new Item[]{new Item("Aged Brie", 2, 2)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals("Aged Brie", actual.name);
    assertEquals(1, actual.sellIn);
    assertEquals(3, actual.quality);
  }


  @Test
  void shouldNotUpdateQuality2WhenIsAnAgedBrieWithZeroSellIn() {
    Item[] items = new Item[]{new Item("Aged Brie", 0, 2)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals("Aged Brie", actual.name);
    assertEquals(-1, actual.sellIn);
    assertEquals(4, actual.quality);
  }


  @Test
  void shouldNotUpdateQualityWhenTheQualityIsAlready50() {
    Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals(4, actual.sellIn);
    assertEquals(50, actual.quality);
  }


  @Test
  void shouldNeverUpdateQualityWhenTheItemIsSulfuras() {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 5)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals("Sulfuras, Hand of Ragnaros", actual.name);
    assertEquals(5, actual.sellIn);
    assertEquals(5, actual.quality);
  }


  @ParameterizedTest
  @MethodSource("backstagePassesTestCases")
  void shouldUpdateQualityWhenTheItemIsBackstagePasses(int sellin, int quality, int expectedSellin, int expectedQuality) {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", sellin, quality)};
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    Item actual = app.items[0];

    assertEquals(expectedSellin, actual.sellIn);
    assertEquals(expectedQuality, actual.quality);
  }

  private static Stream<Arguments> backstagePassesTestCases() {

    return Stream.of(
      Arguments.of(11, 5, 10, 6), //Increases in Quality as it's SellIn value approaches
      Arguments.of(10, 5, 9, 7), // Quality increases by 2 when there are 10 days or less
      Arguments.of(5, 5, 4, 8), // By 3 when there are 5 days or less
      Arguments.of(0, 5, -1, 0) // Quality drops to 0 after the concert
    );
  }

}
