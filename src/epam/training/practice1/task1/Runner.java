package epam.training.practice1.task1;

public class Runner {
    public static void run(){
        NumberFormat numberFormat = new NumberFormat();
        int n = 80;
        System.out.println("Integer: " + n);
        System.out.println("Binary: " + numberFormat.toBinary(n));
        System.out.println("Octal: " + numberFormat.toOctal(n));
        System.out.println("Hexadecimal: " + numberFormat.toHexadecimal(n));

    }
}
