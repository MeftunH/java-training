package streams;

import java.util.Arrays;
import java.util.List;

public class StreamsFirst {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five", "one", "two", "three", "four", "five");
        for (String s : stringList
        ) {
            System.out.println(s);
        }
        System.out.println("-----------------");
        //streame almak demek  siraya almak demektir ve bu siralama yapilirken bir islem yapilir
        //tek tek bakar ve islem yapar
        //strwamlerde terminal ve intermediate islemler vardir
        //terminal islemler streami kapatir ve sonucu verir  zincirin en son noktasidir
        //intermediate islemler streami kapatmaz ve sonucu vermez
        stringList.stream().distinct()
                .skip(2)
                //streame bisey yapmaz etkisiz elemandir anlmi o datayi alip birseyler yapacagiz
                // genelde debug icin kullaniriz islemi sonlandirmadan groebuilmek icin
                .peek(s -> System.out.println("before limit: " + s + " Tread: " + Thread.currentThread().getName()))
                //filter bir intermediate islemdir
                .limit(3)
                .filter(s -> s.length() > 4)
                .forEach(System.out::println);

        //thread nmekanizmasi forkandjoin thread mekanizmasi acar bu mekanizma kendi isi
        // biitiginde baska threadlere yardim deden bir thread mekanizmasidir
        //islemler degil threadler sirali oluyor burada artik bir degil n tane bant oluyor oradan akmaya
        // herseyi parallel yapmak dogru degil bakacsin ne kadar islem yapacaksin buyukse cpubn izin veriyorsa maliyetin kurtariyhorsa parallel yaparsin
        stringList.parallelStream().distinct()
                .skip(2)
                //streame bisey yapmaz etkisiz elemandir anlmi o datayi alip birseyler yapacagiz
                // genelde debug icin kullaniriz islemi sonlandirmadan groebuilmek icin
                .peek(s -> System.out.println("before limit: " + s + " Tread: " + Thread.currentThread().getName()))
                //filter bir intermediate islemdir
                .limit(3)
                .filter(s -> s.length() > 4)
                .forEach(System.out::println);

    }
}
