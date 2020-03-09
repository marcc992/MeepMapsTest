package es.marcmauri.meepmaptest.model.beans;

import com.google.gson.annotations.SerializedName;

public class BeanBusOne {

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
    // companyZoneId = 402
    @SerializedName("lat")
    double lat;
    @SerializedName("lon")
    double lon;
}
