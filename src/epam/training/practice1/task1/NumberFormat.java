package epam.training.practice1.task1;


public class NumberFormat {

    public Number toBinary(int n){
        char[] digits = toBase(n, NumberBase.BINARY);
        return new Number(digits);
    }

    public Number toOctal(int n){
        char[] digits = toBase(n, NumberBase.OCTAL);
        return new Number(digits);
    }

    public Number toHexadecimal(int n){
        char[] digits = toBase(n, NumberBase.HEXADECIMAL);
        return new Number(digits);
    }

    public class Number {
        char[] digits;

        private Number(char[] digits){
            this.digits = digits;
        }

        public char[] getDigits() {
            return digits;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] != '\u0000')
                    builder.append(digits[i]);
            }
            builder.append("\n");
            return new String(builder);
        }
    }

    private char[] toBase(int num, NumberBase base){
        char[] reversedResult = new char[getArraySize(base)];
        for (int i = 0; num != 0; i++) {
            reversedResult[i] = getPresentation(num % base.getBase());
            num = num / base.getBase();
        }
        return (reverse(reversedResult));
    }

    private int getArraySize(NumberBase base){
        switch (base){
            case BINARY:
                return 32;
            case OCTAL:
                return 11;
            case HEXADECIMAL:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    private char getPresentation(int n){
        final char[] presentations = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        return presentations[n];
    }

    private static char[] reverse(char[] arr){
        int arrayLength = arr.length;
        char[] result = new char[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = arr[arrayLength - i - 1];
        }
        return result;
    }
}
