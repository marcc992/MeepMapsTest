package es.marcmauri.meepmaptest.models;

import com.google.gson.annotations.SerializedName;

public class BeanBusTwo {

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
    @SerializedName("companyZoneId")
    int  companyZoneId;
    // companyZoneId = 378
    @SerializedName("lat")
    double lat;
    @SerializedName("lon")
    double lon;
}
