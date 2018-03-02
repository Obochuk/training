package epam.training.practice1.task1;

public enum NumberBase {
    BINARY(2), OCTAL(8), HEXADECIMAL(16);

    private final int base;
    NumberBase(int base){
        this.base = base;
    }
    public int getBase(){
        return base;
    }
}
