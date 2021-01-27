package command;

import console.ConsoleHelper;
import core.SingletonMap;
import exception.InterruptOperationException;

import java.util.Map;
import java.util.ResourceBundle;

public class ShowAllMeasureCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("common_en");
    private SingletonMap mapForConvert = SingletonMap.getInstance();
    @Override
    public void execute() throws InterruptOperationException {
        for(Map.Entry<String,Double> measure: mapForConvert.getMapConvert().entrySet()){
            ConsoleHelper.writeMessage(String.format(res.getString("show.message"), measure.getKey(), measure.getValue()));

        }

    }
}
