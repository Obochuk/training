package controller;

import java.util.function.Function;

public enum TrigonometricFunction {
    SIN(Math::sin),
    COS(Math::cos),
    TNG(Math::tan),
    CTN((d) -> 1.0 / Math.tan(d));


    private Function<Double, Double> trigonometricFunction;

    TrigonometricFunction(Function<Double, Double> trigonometricFunction) {
        this.trigonometricFunction = trigonometricFunction;
    }

    public double calc(double val){
        return trigonometricFunction.apply(val);
    }
}
