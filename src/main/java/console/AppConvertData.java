package console;

import command.CommandExecutor;
import exception.InterruptOperationException;

import java.util.Locale;

public class AppConvertData {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        try
        {
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bye");

        }

    }

}
