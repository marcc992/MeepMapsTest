package es.marcmauri.meepmaptest.model.beans;

import com.google.gson.annotations.SerializedName;

public class BeanResource {

    /**
     * These are the common properties of all public services
     * <p>
     * Each kind of service has its own companyZoneID:
     * Bike     =>  412
     * Bus (1)  =>  402
     * Bus (2)  =>  378
     * Bus (3)  =>  382
     * Ecooltra =>  473
     * Emov     =>  467
     * Taxi     =>  545
     */
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("x")
    private double x;
    @SerializedName("y")
    private double y;
    @SerializedName("companyZoneId")
    private int companyZoneId;

    /**
     * The other properties which might be used on their respective POJOs.
     * These are all commented because of the Technical Test. It is just illustrative.
     */
    /*
    @SerializedName("scheduledArrival")
    private int scheduledArrival;
    @SerializedName("locationType")
    private int locationType;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;

    @SerializedName("licencePlate")
    private String licencePlate;
    @SerializedName("range")
    private int range;
    @SerializedName("batteryLevel")
    private int batteryLevel;
    @SerializedName("seats")
    private int seats;
    @SerializedName("helmets")
    private int helmets;
    @SerializedName("model")
    private String model;
    @SerializedName("resourceImageId")
    private String resourceImageId;

    @SerializedName("station")
    private boolean station;
    @SerializedName("availableResources")
    private int availableResources;
    @SerializedName("spacesAvailable")
    private int spacesAvailable;
    @SerializedName("allowDropoff")
    private boolean allowDropoff;
    @SerializedName("bikesAvailable")
    private int bikesAvailable;

    @SerializedName("pricePerMinuteParking")
    private double pricePerMinuteParking;
    @SerializedName("pricePerMinuteDriving")
    private double pricePerMinuteDriving;
    @SerializedName("engineType")
    private String engineType;

    @SerializedName("resourceType")
    private String resourceType;
    @SerializedName("realTimeData")
    private boolean realTimeData;
     */
    public BeanResource() {
    }

    public BeanResource(String id, String name, double x, double y, int companyZoneId) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.companyZoneId = companyZoneId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getCompanyZoneId() {
        return companyZoneId;
    }
}
