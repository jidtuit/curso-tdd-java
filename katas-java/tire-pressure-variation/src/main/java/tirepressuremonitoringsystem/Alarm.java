package tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private final ISensor sensor;
    private final INotifier notifier;
    private boolean alarmOn = false;

    public Alarm() {
        this.sensor = new Sensor();
        this.notifier = new ConsoleNotifier();
    }
    
    public Alarm(ISensor sensor, INotifier notifier) {
        this.sensor = sensor;
        this.notifier = notifier;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            if(!isAlarmOn()) {
                alarmOn = true;
                notifier.notify("Alarm activated!");
            }
        } else {
            if(isAlarmOn()) {
                alarmOn = false;
                notifier.notify("Alarm deactivated!");
            }
        }
    }

    private boolean isAlarmOn() {
        return alarmOn;
    }
}
