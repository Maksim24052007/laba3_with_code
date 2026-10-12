import java.util.*;

class Human implements Comparable<Human> {
    private String name;
    private String lastname;
    private int age = 0;

    public Human(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " " + lastname + " (" + age + " лет)";
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare (Human h1, Human h2) {
        return h1.getLastname().compareTo(h2.getLastname());
    }
}

public class Main {
    public static void main (String[] args) {
        List<Human> humans = new ArrayList<>();

        humans.add(new Human("Иван", "Яковлев", 40));
        humans.add(new Human("Мария", "Петрова", 10));
        humans.add(new Human("Анна", "Абрамова", 25));

        //a
        Set<Human> humansHashSet = new HashSet<>(humans);
        System.out.println("a) HashSet:         " + humansHashSet);

        //b
        Set<Human> humansLinkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("b) LinkedHashSet:   " + humansLinkedHashSet);

        //c
        Set<Human> humansTreeSet = new TreeSet<>(humans);
        System.out.println("c) TreeSet (Age):   " + humansTreeSet);

        //d
        Set<Human> emptyTreeSet = new TreeSet<>(new HumanComparatorByLastName());
        emptyTreeSet.addAll(humans);
        System.out.println("d) TreeSet (LName): " + emptyTreeSet);

        //e
        Set<Human> anonymTreeSet = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        anonymTreeSet.addAll(humans);
        System.out.println("e) AnonymTreeSet:   " + anonymTreeSet);

        /*
         * f) ОТВЕТЫ НА ВОПРОСЫ:
         *
         * 1. HashSet:
         *    Элементы выводятся в случайном порядке. Порядок зависит от хэш-кодов объектов.
         *    Так как в классе Human не переопределены методы hashCode() и equals(), HashSet использует
         *    стандартную реализацию Object. Она не гарантирует никакого порядка при выводе.
         *
         * 2. LinkedHashSet:
         *    Элементы выводятся строго в порядке их добавления (Яковлев -> Петрова -> Абрамова).
         *    Внутри структуры используется двусвязный список, который запоминает последовательность вставки.
         *
         * 3. TreeSet (пункт c):
         *    Элементы отсортированы по возрастанию возраста (10 -> 25 -> 40).
         *    Коллекция автоматически применила интерфейс Comparable и его метод compareTo(),
         *    который прописан внутри класса Human.
         *
         * 4. TreeSet с компаратором по фамилии (пункт d):
         *    Элементы отсортированы по алфавиту фамилий (Абрамова -> Петрова -> Яковлев).
         *    Мы явно передали в конструктор внешний класс HumanComparatorByLastName,
         *    поэтому TreeSet проигнорировал внутренний Comparable и отсортировал данные по логике компаратора.
         *
         * 5. TreeSet с анонимным компаратором (пункт e):
         *    Элементы снова отсортированы по возрасту (10 -> 25 -> 40).
         *    Логика аналогична пункту "c", но здесь критерий сортировки задан «на лету» без создания
         *    отдельного именованного класса компаратора.
         *
         *Важное замечание про TreeSet
         * TreeSet считает объекты, для которых compare/compareTo вернул 0, одинаковыми.
         * Поэтому два разных человека с одинаковым возрастом в TreeSet по возрасту "склеятся"
         * (останется только первый добавленный), а HashSet и LinkedHashSet сохранят обоих.
         *
         * Главное отличие подходов:
         * - Comparable задает сортировку "по умолчанию" (естественный порядок) для класса.
         * - Comparator (класс или анонимный) позволяет настраивать любые другие виды сортировок извне,
         *   не меняя код самого класса Human.
         */
    }
}