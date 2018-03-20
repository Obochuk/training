package epam.training.practice4.task1.src.test.java;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestTemperatureConverter {
    private TemperatureConverter temperatureConverter = new TemperatureConverter();

    @Test
    @Parameters({Integer.MAX_VALUE + ", 1193046452.7",
            Integer.MIN_VALUE + ", -1193046488.8",
            "32, 0",
            "0, -17.7",
            "-32, -35.5"})
    public void testConcertFtoC(double value, double expected) {
        double result = temperatureConverter.convertFtoC(value);
        assertEquals(expected, result, 0.1);
    }

    @Test
    @Parameters({Integer.MAX_VALUE + ", 3865470596.6",
            Integer.MIN_VALUE + ", -3865470534.4",
            "32, 89.6",
            "0, 32",
            "-32, -25.6"})
    public void testConvertCtoF(double value, double expected) {
        double result = temperatureConverter.convertCtoF(value);
        assertEquals(expected, result, 0.1);
    }

    @Test
    @Parameters({Integer.MAX_VALUE + ", 2147483920.15",
            Integer.MIN_VALUE + ", -2147483374.8",
            "32, 305.15",
            "0, 273.15",
            "-32, 241.15"})
    public void testConvertCtoK(double value, double expected) {
        double result = temperatureConverter.convertCtoK(value);
        assertEquals(expected, result, 0.1);
    }

    @Test
    @Parameters({Integer.MAX_VALUE + ",  2147483373.85",
            Integer.MIN_VALUE + ", -2147483921.15",
            "32, -241.15",
            "0, -273.15",
            "-32, -305.15"})
    public void testConvertKtoC(double value, double expected) {
        double result = temperatureConverter.convertKtoC(value);
        assertEquals(expected, result, 0.1);
    }

    @Test
    @Parameters({Integer.MAX_VALUE + ",  1193046725.92",
            Integer.MIN_VALUE + ", -1193046215.72",
            "32, 273.15",
            "0, 255.37",
            "-32, 237.59"})
    public void testConvertFtoK(double value, double expected) {
        double result = temperatureConverter.convertFtoK(value);
        assertEquals(expected, result, 0.1);
    }

    @Test
    @Parameters({Integer.MAX_VALUE + ",  3865470104.93",
            Integer.MIN_VALUE + ", -3865471026.1",
            "32, -402.07",
            "0, -459.67",
            "-32, -517.3"})
    public void testConvertKtoF(double value, double expected) {
        double result = temperatureConverter.convertKtoF(value);
        assertEquals(expected, result, 0.1);
    }
}
