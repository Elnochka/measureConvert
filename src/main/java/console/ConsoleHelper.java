package console;

import exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle("common_en");
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException
    {
        String line;
        while (true) {
            try {
                line = reader.readLine();
            }
            catch (IOException e) {
                continue;
            }
            if (line.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
            else return line;
        }
    }


    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage(res.getString("operation.CONVERT_FROM_FILE"));
        writeMessage(res.getString("operation.CREATE_JSON_FOR_NEW_MEASURE"));
        writeMessage(res.getString("operation.ADD_MEASURE"));
        writeMessage(res.getString("operation.SHOW_ALL_MEASURE"));
        writeMessage(res.getString("operation.EXIT"));
        Operation op = null;
        while (true){
            try {
                op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString().trim()));
                break;
            }

            catch (IllegalArgumentException e){
                writeMessage(res.getString("invalid.data"));
            }
        }
        return op;

    }

}
