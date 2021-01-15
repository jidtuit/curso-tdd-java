package unit_tests;

import tirepressuremonitoringsystem.INotifier;

public class DummyNotifier implements INotifier {

  private int notified = 0;
  
  @Override
  public void notify(String str) {
    notified++;
  }

  public int getNotified() {
    return notified;
  }
  
  public void reset() {
    notified = 0;
  }
}
