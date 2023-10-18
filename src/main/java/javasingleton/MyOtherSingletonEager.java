package javasingleton;

public enum MyOtherSingletonEager {
    INSTANCE2("i2"), INSTANCE3("i3");

    private final String prefix;

    MyOtherSingletonEager(String i2) {
        this.prefix = i2;
    }

    public void doSomething() {
        System.out.println(prefix + "doSomething");
    }
}
