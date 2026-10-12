import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int N = 10;

        //a
        Integer[] massive = new Integer[N];
        for (int i = 0; i < massive.length; i++) {
            massive[i] = random.nextInt(101);
        }
        System.out.println("a) Массив: " + Arrays.toString(massive));

        //b
        List<Integer> list = new ArrayList<>(Arrays.asList(massive));
        System.out.println("b) Список: " + list);

        //c
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        System.out.println("c) По возрастанию: " + sortedList);

        //d
        Collections.sort(sortedList, Collections.reverseOrder());
        System.out.println("d) В обратном порядке: " + sortedList);

        //e
        Collections.shuffle(sortedList);
        System.out.println("e) Перемешанный список: " + sortedList);

        //f
        Collections.rotate(sortedList, 1);
        System.out.println("f) Сдвиг на один элемент: " + sortedList);

        //g
        Set<Integer> uniqueSet = new LinkedHashSet<>(sortedList);
        sortedList.clear();
        sortedList.addAll(uniqueSet);
        System.out.println("g) Только уникальные элементы: " + sortedList);

        //h
        List<Integer> duplicatesList = new ArrayList<>();
        for (Integer num : new LinkedHashSet<>(list)) {
            if (Collections.frequency(list, num) > 1) {
                duplicatesList.add(num);
            }
        }
        System.out.println("h) Только дублирующиеся элементы: " + duplicatesList);

        //i
        Integer[] newMassive = list.toArray(new Integer[0]);
        System.out.println("i) Массив из списка: " + Arrays.toString(newMassive));

        //j
        System.out.println("j) Количество вхождений каждого числа:");
        List<Integer> arrayAsList = Arrays.asList(newMassive);
        for (Integer num : new LinkedHashSet<>(arrayAsList)) {
            System.out.println("  Число " + num + " встретилось "
                    + Collections.frequency(arrayAsList, num) + " раз(а)");
        }
    }
}