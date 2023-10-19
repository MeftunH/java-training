package streams;

import collection.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsThird {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five", "one", "two", "three", "four", "five");
        Map<String, Person> collect = stringList.stream().distinct()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toMap(s -> s,
                        s -> Person.builder()
                                .build()));
    }
}
