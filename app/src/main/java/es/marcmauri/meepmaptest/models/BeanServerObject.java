package es.marcmauri.meepmaptest.models;

import com.google.gson.annotations.SerializedName;

public class BeanServerObject {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("x")
    double x;
    @SerializedName("y")
    double y;

    @SerializedName("scheduledArrival")
    int  scheduledArrival;
    @SerializedName("locationType")
    int  locationType;
    @SerializedName("lat")
    double lat;
    @SerializedName("lon")
    double lon;

    @SerializedName("licencePlate")
    String licencePlate;
    @SerializedName("range")
    int range;
    @SerializedName("batteryLevel")
    int batteryLevel;
    @SerializedName("seats")
    int seats;
    @SerializedName("helmets")
    int helmets;
    @SerializedName("model")
    String model;
    @SerializedName("resourceImageId")
    String resourceImageId;

    @SerializedName("station")
    boolean station;
    @SerializedName("availableResources")
    int availableResources;
    @SerializedName("spacesAvailable")
    int spacesAvailable;
    @SerializedName("allowDropoff")
    boolean allowDropoff;
    @SerializedName("bikesAvailable")
    int bikesAvailable;

    @SerializedName("pricePerMinuteParking")
    double pricePerMinuteParking;
    @SerializedName("pricePerMinuteDriving")
    double pricePerMinuteDriving;
    @SerializedName("engineType")
    String engineType;

    @SerializedName("resourceType")
    String resourceType;
    @SerializedName("realTimeData")
    boolean realTimeData;

    @SerializedName("companyZoneId")
    int  companyZoneId;
}
