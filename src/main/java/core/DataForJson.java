package core;

public class DataForJson {
    private String unit;
    private double value;

    public DataForJson() {
    }

    public DataForJson(String unit, double value) {

        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }



    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DataForJson{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
