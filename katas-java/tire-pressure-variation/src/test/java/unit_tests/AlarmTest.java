package unit_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tirepressuremonitoringsystem.Alarm;

class AlarmTest {

    private DummySensor sensor;
    private DummyNotifier notifier;
    private Alarm alarm;

    @Test
    void shouldTurnOnTheAlarmWhenPressureIsLowAndAlarmIsOff() {
        // GIVEN
        sensor.setValue(16);

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(1, notifier.getNotified());
    }

    @Test
    void shouldNotNotifyWhenPressureIsLowAndAlarmIsOn() {
        // GIVEN
        sensor.setValue(16);
        alarm.check();

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(1, notifier.getNotified());
    }

    @Test
    void shouldTurnOnTheAlarmWhenPressureIsHighndAlarmIsOff() {
        // GIVEN
        sensor.setValue(22);

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(1, notifier.getNotified());
    }

    @Test
    void shouldNotNotifyWhenPressureIsHighAndAlarmIsOn() {
        // GIVEN
        sensor.setValue(22);
        alarm.check();

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(1, notifier.getNotified());
    }

    @Test
    void shouldNotNotifyWhenPressureIsNormalAndAlarmIsOff() {
        // GIVEN
        sensor.setValue(21);

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(0, notifier.getNotified());
    }

    @Test
    void shouldturnOffTheAlarmWhenPressureIsNormalAndAlarmIsOn() {
        // GIVEN
        sensor.setValue(22);
        alarm.check();
        sensor.setValue(21);
        notifier.reset();

        // WHEN
        alarm.check();

        // THEN
        Assertions.assertEquals(1, notifier.getNotified());
    }


    @BeforeEach
    void setup() {
        sensor = new DummySensor();
        notifier = new DummyNotifier();
        alarm = new Alarm(sensor, notifier);
    }

}

