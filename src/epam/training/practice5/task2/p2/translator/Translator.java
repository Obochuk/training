package translator;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> dictionary = new HashMap<>();

    public void addTranslation(String english, String russian){
        dictionary.put(english.toLowerCase(), russian);
    }

    public String translate(String englishText){
        String[] englishWords = englishText.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < englishWords.length; i++) {
            String wordTranslation = translateWord(englishWords[i]);
            builder.append(wordTranslation).append(' ');
        }
        return builder.toString();
    }

    private String translateWord(String englishWord){
        String translation = dictionary.get(englishWord.toLowerCase());
        if (translation == null)
            return englishWord;
        return translation;
    }
}
