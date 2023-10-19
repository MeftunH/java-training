package lambdas;

import java.util.function.*;

public class JavaInterface {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World";
        Consumer<String> consumer = (s) -> System.out.println("pref :" + s);
        //2 girdi consuemr varyanti
        BiConsumer<String, Integer> bc1 = (s, i) -> System.out.println(s + " " + i);
        Function<String, Integer> f1 = (s) -> Integer.parseInt(s);

        Predicate<String> p1 = (s) -> s.length() > 10;
    }
}
