package excel.firstwork;

public class ItemData {

    private String partNo;
    private String make;
    private String model;
    private String submodel;
    private String drive;
    private String kitRequired;
    private String year;
    private String series;
    private Double part;
    private String lift;
    private String position;


    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSubmodel() {
        return submodel;
    }

    public void setSubmodel(String submodel) {
        this.submodel = submodel;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getKitRequired() {
        return kitRequired;
    }

    public void setKitRequired(String kitRequired) {
        this.kitRequired = kitRequired;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Double getPart() {
        return part;
    }

    public void setPart(Double part) {
        this.part = part;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ItemData{" +
                "partNo='" + partNo + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", submodel='" + submodel + '\'' +
                ", drive='" + drive + '\'' +
                ", kitRequired='" + kitRequired + '\'' +
                ", year='" + year + '\'' +
                ", series='" + series + '\'' +
                ", part='" + part + '\'' +
                ", lift='" + lift + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
