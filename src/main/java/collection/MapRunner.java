package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapRunner {
    public static void main(String[] args) {
        //TEK EKSISI DIGELERINDEN DHA FaL OBJE YARATARARKJ DAHA FAZLA MEMORY YER
        Map<String,Person> personMap=new HashMap<>();
        Map<String,Person> personMap2=new HashMap<>();
        //BUYUK CACHEDE BU SEKILDE OLACAK
        Map<String,Person> personConcurrentMap=new ConcurrentHashMap<>(1_200_000,0.9f,1_000);
        for (int i = 0; i < 1_000_000; i++) {
            Person person=new Person("Person"+i,i,"personMail"+i);
            personMap.put(person.getName(),person);
            personMap2.put(person.getName(),person);
            personConcurrentMap.put(person.getName(),person);
        }
        //DAHA KUCUK OLDUGUNDA DAHA IYI CALISIR VE DAHA FAZLA MEMORY YER
        Map<String,Person> personConcurrentMap2=new ConcurrentHashMap<>(60_000,
                0.9f,600);
        // bunu  kullanma bu daha yavas
        Map<String,Person> personMap22=new HashMap<>(60_000,
                0.9f);
        //DSL(domain specific language) satira fokus olup onun disina cikmiyor ve makro okuma yapiyor
        personMap.put("Adam",
                Person.builder()
                        .withName("Adam")
                        .withAge(1)
                        .build());

        //ekleme yaparken eger ayni key varsa sonuncuyu alir
        personMap.put("Adam_test",
                Person.builder()
                        .withName("Adam")
                        .withAge(1)
                        .build());
        //boylece birden fazla keyi kullanabiliyoruz arama yparaken
        personMap.put("test_Adam_test",
                Person.builder()
                        .withName("Adam")
                        .withAge(1)
                        .build());
        //traverse 3 yolu var
        //icinde verileri collection olarak alip donebiliriz
        Collection<Person> values = personMap.values();
        for (Person value : values) {
            System.out.println(value);
        }
        //2,yol keyleri alabiliyoruz
        //bunu cok kullanma ne aradigini cok iyi bilmen lazim
        Set<String> stringsSet = personMap.keySet();
        for (String s : stringsSet) {
            System.out.println(s);
        }
        //3.yol entryleri alabiliyoruz
        Set<Map.Entry<String, Person>> entries = personMap.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
