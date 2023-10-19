package lambdas;

public class FunctionalRunner {
    public static void main(String[] args) {
        IExecute execute = (stringParam, intVal) -> stringParam + " - " + intVal;
        System.out.println(execute.execute("Hello", 1));
    }
}
