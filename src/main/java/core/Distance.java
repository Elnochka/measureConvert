package core;

public class Distance {
    private String unit;
    private double value;
    private String convert_to;

    public Distance(String unit, double value, String convert_to) {
        this.unit = unit;
        this.value = value;
        this.convert_to = convert_to;
    }

    public Distance() {
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

    public String getConvert_to() {
        return convert_to;
    }

    public void setConvert_to(String convert_to) {
        this.convert_to = convert_to;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                ", convert_to='" + convert_to + '\'' +
                '}';
    }
}
