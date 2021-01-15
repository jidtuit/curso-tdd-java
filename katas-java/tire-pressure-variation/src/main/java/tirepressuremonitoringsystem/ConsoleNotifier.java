package tirepressuremonitoringsystem;

public class ConsoleNotifier implements INotifier{

  @Override
  public void notify(String str) {
    System.out.println(str);
  }
}
