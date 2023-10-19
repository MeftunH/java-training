package strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringRunner {
    private static final Logger logger = LoggerFactory.getLogger(StringRunner.class);
    public static void main(String[] args) {
        String string = "Hello";
        //Aslinda esit degil ayni heapteki ayni objeyi gosteriyorlar
        if (string == "Hello") {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
        //DOGRU KULLANIM bu referanslari karsilastirir
        if (string.equals("Hello")) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
        //e ozaman bunun dadogru olmasi lazim
        if (string ==new String("Hello")) {
            System.out.println("They are equal");
        } else {
            System.out.println("They are not equal");
        }
        //concat yenisini yaratmiyor
        string.concat("World");
        //Boyle yapip yeni bir obje yaratmak lazim dogru  calismasi icin
        String concat=string.concat("World");
        System.out.println(concat);
        //1 obje olusur
        String concat2="Hello"+string+concat;
        //2.obje olusur
        concat2+="World";

        for (int i = 0; i < 10; i++) {
            //Bu sekilde yaparsaniz 10 obje olusur
            String concat3="Hello"+string+concat;
        }
        //threadsafe degil
        StringBuffer stringBuffer=new StringBuffer();
        //threadsafe olan hali
        StringBuilder stringBuilder=new StringBuilder();

        for (int i = 0; i < 10; i++) {
            //Bu sekilde yaparsaniz 10 obje olusur
            stringBuilder.append(" ")
                    .append(i);
        }
        System.out.println(stringBuilder.toString());
        //bosu bosuna obje yaratmamis olursunuz garbage collectoru rahatlatmis olursunuz
        if(logger.isDebugEnabled()){
            logger.debug("Hello from Log4j 2 - num: {}");
        }
    }
}
