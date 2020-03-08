package es.marcmauri.meepmaptest.models;

import com.google.gson.annotations.SerializedName;

public class BeanBikes {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("x")
    double x;
    @SerializedName("y")
    double y;

    @SerializedName("realTimeData")
    boolean realTimeData;

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

    @SerializedName("companyZoneId")
    int  companyZoneId;
    // companyZoneId = 412 => Bikes?
}
