package lambdas;

public class FunctionalRunner {
    public static void main(String[] args) {
        final String prefix = "pref: ";
        IExecute execute = (stringParam, intVal) -> prefix + " " + stringParam + " - " + intVal;
        System.out.println(execute.execute("Hello", 1));
        //anon class bunun icin compileda yeni bir class olusturur
        //normalde sadece bir method oldugu icin anon class olusturulur bunun icin
        //functional interface annotationu eklmemiz lazim
        //labdada class olusturulmaz anon class ile farki bu
        IExecute executeLoc1 = new IExecute() {
            @Override
            public String execute(String stringParam, Integer intVal) {
                return prefix + " " + stringParam + " - " + intVal;
            }
        };
        System.out.println(executeLoc1.execute("Hello", 1));
        //olmaz ya final yada effectively final olacak
        //prefix = "pref2: ";

        IExecute execute2=(w,p)->prefix+" "+w+" - "+p;
        System.out.println(execute2.execute("test lambda", 10));
    }

}
