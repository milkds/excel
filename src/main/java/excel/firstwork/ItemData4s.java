package excel.firstwork;

public class ItemData4s {
    private String partNo;
    private String make;
    private String model;
    private String submodel;
    private String drive;
    private String kitRequired;
    private String year;
    private String frontLift;
    private String rearLift;
    private String position;
    private String rearSeries;
    private String frontSeries;
    private Double frontPart;
    private Double rearPart;
    private Boolean boolField;


    @Override
    public String toString() {
        return "ItemData4s{" +
                "partNo='" + partNo + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", submodel='" + submodel + '\'' +
                ", drive='" + drive + '\'' +
                ", kitRequired='" + kitRequired + '\'' +
                ", year='" + year + '\'' +
                ", frontLift='" + frontLift + '\'' +
                ", rearLift='" + rearLift + '\'' +
                ", position='" + position + '\'' +
                ", rearSeries='" + rearSeries + '\'' +
                ", frontSeries='" + frontSeries + '\'' +
                ", frontPart=" + frontPart +
                ", rearPart=" + rearPart +
                ", boolField=" + boolField +
                '}';
    }

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

    public String getRearSeries() {
        return rearSeries;
    }

    public void setRearSeries(String rearSeries) {
        this.rearSeries = rearSeries;
    }

    public Double getFrontPart() {
        return frontPart;
    }

    public void setFrontPart(Double frontPart) {
        this.frontPart = frontPart;
    }

    public String getFrontLift() {
        return frontLift;
    }

    public void setFrontLift(String frontLift) {
        this.frontLift = frontLift;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRearLift() {
        return rearLift;
    }

    public void setRearLift(String rearLift) {
        this.rearLift = rearLift;
    }

    public String getFrontSeries() {
        return frontSeries;
    }

    public void setFrontSeries(String frontSeries) {
        this.frontSeries = frontSeries;
    }

    public Double getRearPart() {
        return rearPart;
    }

    public void setRearPart(Double rearPart) {
        this.rearPart = rearPart;
    }

    public Boolean getBoolField() {
        return boolField;
    }

    public void setBoolField(Boolean boolField) {
        this.boolField = boolField;
    }
}
