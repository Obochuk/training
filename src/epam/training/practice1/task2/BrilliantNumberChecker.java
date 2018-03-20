public class BrilliantNumberChecker {

    public void run(){
        int[] brilliantNumbers = getBrilliantNumbers(50_000);
        for (int i = 0; i < brilliantNumbers.length; i++) {
            if (brilliantNumbers[i] != 0)
                System.out.print(brilliantNumbers[i] + " ");
        }
    }

    /**
     * finds brilliant numbers
     * @param delimeter max number that is checked
     * @return array of integer that contains brilliant numbers and 0's after them
     */
    public int[] getBrilliantNumbers(int delimeter){
        final int MAX_AMOUNT_OF_NUMBERS = 5;
        int[] brilliantNumbers = new int[MAX_AMOUNT_OF_NUMBERS];
        int index = 0;
        for (int number = 1; number < delimeter; number++){
            if (isBrilliantNumber(number))
                brilliantNumbers[index++] = number;
        }
        return brilliantNumbers;
    }

    /**
     * check if number is brilliant
     * @param n is bigger then 1
     * @return {@code true} if n is brilliant number, {@code false} otherwise
     */
    public boolean isBrilliantNumber(int n){
        int divider = 1;
        int DividersSum = 0;
        while (divider != n){
            if (n % divider == 0)
                DividersSum = DividersSum + divider;
            if (DividersSum > n)
                return false;
            divider++;
        }
        return (DividersSum == n);
    }
}