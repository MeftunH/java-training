package javasingleton;

public class EnumRun {
    public static void main(String[] args) {
        MyOtherSingletonEager.INSTANCE2.doSomething();
        MyOtherSingletonEager.INSTANCE3.doSomething();
    }
}
