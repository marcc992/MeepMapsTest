package es.marcmauri.meepmaptest.models;

import com.google.gson.annotations.SerializedName;

public class BeanEcooltra {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("x")
    double x;
    @SerializedName("y")
    double y;

    @SerializedName("licencePlate")
    String licencePlate;
    @SerializedName("range")
    int range;
    @SerializedName("batteryLevel")
    int batteryLevel;
    @SerializedName("helmets")
    int helmets;
    @SerializedName("model")
    String model;
    @SerializedName("resourceImageId")
    String resourceImageId;

    @SerializedName("realTimeData")
    boolean realTimeData;
    @SerializedName("resourceType")
    String resourceType;

    @SerializedName("companyZoneId")
    int  companyZoneId;
    // companyZoneId = 473 => e-cooltra?
}
