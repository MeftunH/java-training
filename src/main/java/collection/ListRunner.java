package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListRunner {
    //function icinde olusturudugunda kourmana gerek yok ama global olusturursaniz ozellikle
    //statikleri koruman gerekiyor cunku birkca thread ayni anda erisebilir
    private final List<String> globalList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        //en cok corrupt olabilen veri tipidir arraylist
        List<String> stringList = new ArrayList<>();
        //multiple threads can access this list.Multhithrwead ortamlarda yazmayi handle ediyor.
        // fAKAT COLLECTIONLARDA DONERKEN BASKA THREAD BISEY EKJLERSE CONCURRENT MODIFICATIONE XCEPTION ALIRSINIZ
        //BUNU COZMEK ICIN COPYONWRITEARRAYLIST KULLANILIR
        List<String> stringVector = new Vector<>();
        //BU ONU DA COZUTYOR FAKAT HER EKLEDIGINDE YENI BIR VECTOR OLUSTURUYOR
        //Az yazma cok okuma icin kullanilir
        List<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        //simpledataformat threadsade deguil hasmap threadsfe degiul

        List<String> strings = new ArrayList<>();

        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            strings.add("a");
        }
        System.gc();
        Thread.sleep(1000);
        System.out.println("Delta = " + (System.currentTimeMillis() - delta));
    }
    public void method1(){
       List<String> strings = new ArrayList<>();
       strings.add("a");
    }
}
