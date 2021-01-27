package command;

import console.ConsoleHelper;
import exception.InterruptOperationException;

import java.util.ResourceBundle;

public class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("common_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        if (res.getString("yes").equals(answer)){
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
