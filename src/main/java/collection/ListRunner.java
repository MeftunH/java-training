package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListRunner {
    public static void main(String[] args) {
        //en cok corrupt olabilen veri tipidir arraylist
        List<String> stringList=new ArrayList<>();
        //multiple threads can access this list.Multhithrwead ortamlarda yazmayi handle ediyor.
        // fAKAT COLLECTIONLARDA DONERKEN BASKA THREAD BISEY EKJLERSE CONCURRENT MODIFICATIONE XCEPTION ALIRSINIZ
        //BUNU COZMEK ICIN COPYONWRITEARRAYLIST KULLANILIR
        List<String> stringVector=new Vector<>();
        //BU ONU DA COZUTYOR FAKAT HER EKLEDIGINDE YENI BIR VECTOR OLUSTURUYOR
        //Az yazma cok okuma icin kullanilir
        List<String> stringCopyOnWriteArrayList=new CopyOnWriteArrayList<>();
        //simpledataformat threadsade deguil hasmap threadsfe degiul
    }
}
