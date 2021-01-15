package tirepressuremonitoringsystem;

public class ConsoleNotifier implements Notifier {

  @Override
  public void notify(String str) {
    System.out.println(str);
  }
}
