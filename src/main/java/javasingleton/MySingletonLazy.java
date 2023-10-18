package javasingleton;

public class MySingletonLazy {
    private static MySingletonLazy instance;

    private MySingletonLazy() {

    }

    public static MySingletonLazy getInstance() {
        //null checki onceisnde yaparsaniz null checki siraya girer ikisi de ayni andsa yapar
       if (instance == null) {
          synchronized (MySingletonLazy.class) {
             if (instance == null) {
                instance = new MySingletonLazy();
             }
          }
       }
       return instance;

    }
}
