package command;

import console.Operation;
import exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private CommandExecutor(){}
    private static Map<Operation, Command> map;
    static {
        map = new HashMap<Operation, Command>();
        map.put(Operation.CONVERT_FROM_FILE, new ConvertDataCommand());
        map.put(Operation.CREATE_JSON_FOR_NEW_MEASURE, new CreateJsonCommand());
        map.put(Operation.ADD_MEASURE, new AddMeasureCommand());
        map.put(Operation.SHOW_ALL_MEASURE, new ShowAllMeasureCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }
    public static final void execute(Operation operation) throws InterruptOperationException {
        map.get(operation).execute();
    }
}
