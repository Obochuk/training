import translator.Translator;
import utils.InputUtil;

public class Runner {
    public static void run(){
        Translator translator = new Translator();
        while (true){
            System.out.println("Enter new english word or n to exit.");
            String englishWord = InputUtil.readLine();
            if (englishWord.equals("n"))
                break;
            System.out.println("Enter it`s translation: ");
            String translation = InputUtil.readLine();
            translator.addTranslation(englishWord, translation);
        }

        System.out.println("Enter phrase to translate: ");
        String text = InputUtil.readLine();
        String translation = translator.translate(text);
        System.out.println("Translation: " + translation);
    }
}
