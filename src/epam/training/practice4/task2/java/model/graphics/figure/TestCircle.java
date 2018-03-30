package epam.training.practice4.task2.java.model.graphics.figure;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestCircle {

    @Test
    @Parameters({
            "5",
            "900",
            "0"
    })
    public void testCreationSuccess(double radius){
        Circle circle = new Circle("", radius);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({
            "-0.2",
            "-5",
            "-855"
    })
    public void testCreationFailure(double radius){
        Circle circle = new Circle("", radius);
    }

    @Test
    @Parameters({
            "78.54, 5",
            "4.52, 1.2",
            "314.16, 10"
    })
    public void testArea(double expected, double radius){
        Circle circle = new Circle("", radius);
        assertEquals(expected, circle.calcArea(), 0.1);
    }
}
