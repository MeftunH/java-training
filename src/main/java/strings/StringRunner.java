package strings;

public class StringRunner {
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
    }
}
