package command;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import console.ConsoleHelper;
import core.DataForConvert;
import exception.InterruptOperationException;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class CreateJsonCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("common_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("choose.file"));
        String fileMeasure = ConsoleHelper.readString();
        ConsoleHelper.writeMessage(res.getString("choose.unit"));
        String unit = ConsoleHelper.readString();
        ConsoleHelper.writeMessage(res.getString("choose.value"));
        Double value = Double.parseDouble(ConsoleHelper.readString());

            DataForConvert dataForConvert = new DataForConvert(unit, value);
            ObjectMapper mapper = new ObjectMapper();
            try (JsonGenerator jGenerator = mapper.getFactory().createGenerator(new File(fileMeasure)
                    , JsonEncoding.UTF8)) {

                jGenerator.useDefaultPrettyPrinter();
                jGenerator.writeStartObject();

                jGenerator.writeFieldName("dataForConvert");
                jGenerator.writeObject(dataForConvert);

            } catch (IOException e) {
                e.printStackTrace();
            }
            ConsoleHelper.writeMessage(res.getString("file.create.message"));

    }
}
