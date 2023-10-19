package lambdas;

public class ExecuteImpl implements IExecute {
    @Override
    public String execute(String stringParam, Integer intVal) {
        return stringParam + " - "+ intVal;
    }
}
