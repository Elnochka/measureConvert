package command;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import console.ConsoleHelper;
import core.SingletonMap;
import exception.InterruptOperationException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AddMeasureCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("common_en");
    private SingletonMap mapForConvert = SingletonMap.getInstance();
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("choose.file"));
        String fileForMap = ConsoleHelper.readString();

            try (JsonParser jParser = new JsonFactory().createParser(new File(fileForMap))) {
                while (jParser.nextToken() != JsonToken.END_OBJECT) {
                    String basename = jParser.getCurrentName();
                    if ("dataForConvert".equals(basename)) {
                        String convertFromJson = "";
                        double coefficientFromJson = .0;
                        while (jParser.nextToken() != JsonToken.END_OBJECT) {

                            String fieldname = jParser.getCurrentName();
                            if ("convert".equals(fieldname)) {
                                jParser.nextToken();
                                convertFromJson = jParser.getText();

                            }

                            if ("coefficient".equals(fieldname)) {
                                jParser.nextToken();
                                coefficientFromJson = jParser.getDoubleValue();

                            }

                        }
                        HashMap<String, Double> hashMapForMeasure = mapForConvert.getMapConvert();
                        hashMapForMeasure.put(convertFromJson, coefficientFromJson);
                        mapForConvert.setMapConvert(hashMapForMeasure);

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ConsoleHelper.writeMessage(res.getString("measure.add.message"));

    }
}
