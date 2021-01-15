package unit_tests;

import tirepressuremonitoringsystem.Sensor;

public class SensorSpy implements Sensor {

  private double value;

  @Override
  public double popNextPressurePsiValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}
