package core;

public class DataForConvert {
    private String convert;
    private double coefficient;

    public DataForConvert(String convert, double coefficient) {
        this.convert = convert;
        this.coefficient = coefficient;
    }

    public DataForConvert() {
    }

    public String getConvert() {
        return convert;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "DataForConvert{" +
                "convert='" + convert + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}
