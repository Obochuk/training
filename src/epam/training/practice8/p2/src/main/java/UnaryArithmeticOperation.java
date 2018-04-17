
public class UnaryArithmeticOperation {
    private double value;

    public UnaryArithmeticOperation(){}

    public UnaryArithmeticOperation(double value) {
        this.value = value;
    }

    public UnaryArithmeticOperation increment(){
        value++;
        return this;
    }

    public UnaryArithmeticOperation decrement(){
        value--;
        return this;
    }

    public UnaryArithmeticOperation changeSign(){
        value = -value;
        return this;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
