package entities;

import java.text.NumberFormat;

public class ResultWithPrecision {
    private double result;
    private int precision;

    public ResultWithPrecision(){}

    public ResultWithPrecision(double result, int precision) {
        this.result = result;
        this.precision = precision;
    }

    public String getFormattedResult(){
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMaximumFractionDigits(precision);
        formatter.setMinimumFractionDigits(precision);
        return formatter.format(result);
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }
}
