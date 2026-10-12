import java.util.*;

class PrimesGenerator implements Iterable<Integer> {
    private final List<Integer> primes = new ArrayList<>();

    public PrimesGenerator(int n) {
        int candidate = 2;
        while (primes.size() < n) {
            if (isPrime(candidate)) {
                primes.add(candidate);
            }
            candidate++;
        }
    }

    private boolean isPrime(int x) {
        for (int p : primes) {
            if (p * p > x) break;
            if (x % p == 0) return false;
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }


    public Iterator<Integer> reverseIterator() {
        return new Iterator<Integer>() {
            private int i = primes.size() - 1;

            @Override
            public boolean hasNext() {
                return i >= 0;
            }

            @Override
            public Integer next() {
                return primes.get(i--);
            }
        };
    }
}

class PrimesGeneratorTest {
    public void test(int n) {
        PrimesGenerator generator = new PrimesGenerator(n);

        System.out.println("Прямой порядок:");
        Iterator<Integer> it = generator.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\nОбратный порядок:");
        Iterator<Integer> rit = generator.reverseIterator();
        while (rit.hasNext()) {
            System.out.print(rit.next() + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько простых чисел сгенерировать? ");
        int n = scanner.nextInt();
        new PrimesGeneratorTest().test(n);
    }
}