package javasingleton;

public class MySingletonEager {
    private static final MySingletonEager instance = new MySingletonEager();

    private MySingletonEager() {

    }

    public static MySingletonEager getInstance() {
        return instance;
    }
}
