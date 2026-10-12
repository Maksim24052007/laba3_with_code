import java.util.HashMap;
import java.util.Map;

public class Main {
    public static <K, V> Map<V, K> invertMap(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();

        if (sourceMap == null) {
            return invertedMap;
        }

        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            invertedMap.put(entry.getValue(), entry.getKey());
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> original = new HashMap<>();
        original.put("Один", 1);
        original.put("Два", 2);
        original.put("Три", 3);

        System.out.println("Исходная карта: " + original);

        Map<Integer, String> inverted = invertMap(original);
        System.out.println("Инвертированная карта: " + inverted);

        //пример потери данных при одинаковых значениях
        Map<String, Integer> withDuplicates = new HashMap<>();
        withDuplicates.put("a", 1);
        withDuplicates.put("b", 1);
        System.out.println("Карта с одинаковыми значениями: " + withDuplicates);
        System.out.println("Инвертированная (одна пара потеряна): " + invertMap(withDuplicates));
    }
}