package service.convert;

public class AngleConverter {

    public static double convertToRadians(double value, AngleUnit angleUnit) {
        switch (angleUnit) {
            case RADIANS:
                return value;
            case DEGREES:
                return value * Math.PI / 180;
            default:
                throw new IllegalArgumentException("Unsupported unit '" + angleUnit + "'");
        }
    }

}
