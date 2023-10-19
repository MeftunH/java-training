package collection;

import java.util.HashSet;
import java.util.Set;

public class SetRunner {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("A");
        System.out.println(strings);
    }}
