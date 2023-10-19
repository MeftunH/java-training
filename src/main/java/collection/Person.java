package collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Person {
    private String name;
    private int age;
    private String email;
}
