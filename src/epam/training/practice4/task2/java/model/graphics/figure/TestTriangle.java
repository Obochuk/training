package epam.training.practice4.task2.java.model.graphics.figure;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TestTriangle {

    @Test
    @Parameters({
            "5, 5",
            "900, 0.8",
            "0, 0"
    })
    public void testCreationSuccess(double height, double base){
        Triangle triangle = new Triangle("", height, base);

        assertEquals(triangle.getHeight(), height, 0.001);
        assertEquals(triangle.getBase(), base, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({
            "8, -0.2",
            "-5, 2",
            "-855, -125"
    })
    public void testCreationFailure(double height, double base){
        Triangle triangle = new Triangle("", height, base);
    }

    @Test
    @Parameters({
            "12.5, 5, 5",
            "0, 0, 0",
            "34.34, 10.1 , 6.8"
    })
    public void testArea(double expected, double height, double base){
        Triangle triangle = new Triangle("", height, base);
        assertEquals(expected, triangle.calcArea(), 0.01);
    }

}
