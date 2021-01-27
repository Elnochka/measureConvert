package command;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import console.ConsoleHelper;
import core.DataForJson;
import core.Distance;
import core.SingletonMap;
import exception.InterruptOperationException;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

public class ConvertDataCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("common_en");
    private SingletonMap mapForConvert = SingletonMap.getInstance();
    private Distance distance = new Distance();
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("choose.infile"));
        String fileJson = ConsoleHelper.readString();
        ConsoleHelper.writeMessage(res.getString("choose.outfile"));
        String outFileJson = ConsoleHelper.readString();

        readJsonForConvert(fileJson);
        convertDataFromDistance(outFileJson);
    }

    public void readJsonForConvert(String fileJson){

        try (JsonParser jParser = new JsonFactory().createParser(new File(fileJson))) {
            while (jParser.nextToken() != JsonToken.END_OBJECT) {
                String basename = jParser.getCurrentName();
                if ("distance".equals(basename)) {
                    String unitFromJson = "";
                    double valueFromJson = .0;
                    while (jParser.nextToken() != JsonToken.END_OBJECT) {

                        String fieldname = jParser.getCurrentName();
                        if ("unit".equals(fieldname)) {
                            jParser.nextToken();
                            unitFromJson = jParser.getText();
                        }

                        if ("value".equals(fieldname)) {
                            jParser.nextToken();
                            valueFromJson = jParser.getDoubleValue();
                        }

                    }
                    distance.setUnit(unitFromJson);
                    distance.setValue(valueFromJson);
                }

                if ("convert_to".equals(basename)) {
                    jParser.nextToken();
                    String convert_toFromJson = jParser.getText();
                    distance.setConvert_to(convert_toFromJson);
                }
            }

        } catch (IOException e) {
             e.printStackTrace();
        }

    }


    public void convertDataFromDistance(String outFileJson) {
        double inNumber = mapForConvert.getMapConvert().get(distance.getUnit());
        double outNumber = mapForConvert.getMapConvert().get(distance.getConvert_to());
        double convertValue = Math.round((distance.getValue() * inNumber / outNumber) * 100.0) / 100.0;
        DataForJson dataForJson = new DataForJson(distance.getConvert_to(), convertValue);
        writeToJson(dataForJson, outFileJson);
    }


    public void writeToJson(DataForJson dataForJson, String outFileJson){
        ObjectMapper mapper = new ObjectMapper();
        try (JsonGenerator jGenerator = mapper.getFactory().createGenerator(new File(outFileJson)
                , JsonEncoding.UTF8)) {

            jGenerator.useDefaultPrettyPrinter();
            jGenerator.writeStartObject();

            jGenerator.writeStringField("unit", dataForJson.getUnit());
            jGenerator.writeNumberField("value", dataForJson.getValue());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
