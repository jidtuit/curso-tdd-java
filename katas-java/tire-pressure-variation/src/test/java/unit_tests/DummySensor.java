package unit_tests;

import tirepressuremonitoringsystem.ISensor;

public class DummySensor implements ISensor {

  private double value;

  @Override
  public double popNextPressurePsiValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}
