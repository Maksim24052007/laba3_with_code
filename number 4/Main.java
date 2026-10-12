import java.util.*;

public class Main {
    public static void main(String[] args) {
        String text = "The rain begins to fall. Outside the window, the rain drops hit the glass, one by one. It is a steady rain, a heavy rain, a rain that does not want to stop.";
        String cleanText = text.toLowerCase().replaceAll("\\p{Punct}", "").trim();
        String[] words = cleanText.split("\\s+");
        System.out.println("Слова: " + Arrays.toString(words));
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений каждого cлова:");
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("  Слово " + entry.getKey() + " встретилось " + entry.getValue() + " раз(а)");
        }


    }
}