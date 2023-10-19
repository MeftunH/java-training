package streams;

import collection.Person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSecond {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five", "one", "two", "three", "four", "five");
        IntSummaryStatistics distinct = stringList.parallelStream().distinct()
                .skip(2)
                .limit(10)
                .distinct()
                .map(s -> Person.builder().withName(s).build())
                .peek(s -> s.setAge(s.getName().length() * 8))
                .map(Person::getAge).filter(i -> i > 35)
                .mapToInt(i->i-5).summaryStatistics();
        System.out.println(distinct);
    }
}
