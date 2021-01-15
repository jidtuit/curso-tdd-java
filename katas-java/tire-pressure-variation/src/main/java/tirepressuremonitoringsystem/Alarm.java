package tirepressuremonitoringsystem;

public class Alarm {
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    private final Sensor sensor;
    private final Notifier notifier;
    private boolean alarmOn = false;

    public Alarm() {
        this.sensor = new RealSensor();
        this.notifier = new ConsoleNotifier();
    }

    public Alarm(Sensor sensor, Notifier notifier) {
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
