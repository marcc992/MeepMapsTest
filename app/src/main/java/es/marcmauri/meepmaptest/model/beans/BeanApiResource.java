package es.marcmauri.meepmaptest.model.beans;

import com.google.gson.annotations.SerializedName;

public class BeanApiResource {

    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("x")
    double x;
    @SerializedName("y")
    double y;

    @SerializedName("scheduledArrival")
    int scheduledArrival;
    @SerializedName("locationType")
    int locationType;
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
    int companyZoneId;

    public BeanApiResource() {
    }

    public BeanApiResource(String id, String name, double x, double y, int scheduledArrival,
                           int locationType, double lat, double lon, String licencePlate,
                           int range, int batteryLevel, int seats, int helmets, String model,
                           String resourceImageId, boolean station, int availableResources,
                           int spacesAvailable, boolean allowDropoff, int bikesAvailable,
                           double pricePerMinuteParking, double pricePerMinuteDriving,
                           String engineType, String resourceType, boolean realTimeData,
                           int companyZoneId) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.scheduledArrival = scheduledArrival;
        this.locationType = locationType;
        this.lat = lat;
        this.lon = lon;
        this.licencePlate = licencePlate;
        this.range = range;
        this.batteryLevel = batteryLevel;
        this.seats = seats;
        this.helmets = helmets;
        this.model = model;
        this.resourceImageId = resourceImageId;
        this.station = station;
        this.availableResources = availableResources;
        this.spacesAvailable = spacesAvailable;
        this.allowDropoff = allowDropoff;
        this.bikesAvailable = bikesAvailable;
        this.pricePerMinuteParking = pricePerMinuteParking;
        this.pricePerMinuteDriving = pricePerMinuteDriving;
        this.engineType = engineType;
        this.resourceType = resourceType;
        this.realTimeData = realTimeData;
        this.companyZoneId = companyZoneId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(int scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public int getLocationType() {
        return locationType;
    }

    public void setLocationType(int locationType) {
        this.locationType = locationType;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getHelmets() {
        return helmets;
    }

    public void setHelmets(int helmets) {
        this.helmets = helmets;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResourceImageId() {
        return resourceImageId;
    }

    public void setResourceImageId(String resourceImageId) {
        this.resourceImageId = resourceImageId;
    }

    public boolean isStation() {
        return station;
    }

    public void setStation(boolean station) {
        this.station = station;
    }

    public int getAvailableResources() {
        return availableResources;
    }

    public void setAvailableResources(int availableResources) {
        this.availableResources = availableResources;
    }

    public int getSpacesAvailable() {
        return spacesAvailable;
    }

    public void setSpacesAvailable(int spacesAvailable) {
        this.spacesAvailable = spacesAvailable;
    }

    public boolean isAllowDropoff() {
        return allowDropoff;
    }

    public void setAllowDropoff(boolean allowDropoff) {
        this.allowDropoff = allowDropoff;
    }

    public int getBikesAvailable() {
        return bikesAvailable;
    }

    public void setBikesAvailable(int bikesAvailable) {
        this.bikesAvailable = bikesAvailable;
    }

    public double getPricePerMinuteParking() {
        return pricePerMinuteParking;
    }

    public void setPricePerMinuteParking(double pricePerMinuteParking) {
        this.pricePerMinuteParking = pricePerMinuteParking;
    }

    public double getPricePerMinuteDriving() {
        return pricePerMinuteDriving;
    }

    public void setPricePerMinuteDriving(double pricePerMinuteDriving) {
        this.pricePerMinuteDriving = pricePerMinuteDriving;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public boolean isRealTimeData() {
        return realTimeData;
    }

    public void setRealTimeData(boolean realTimeData) {
        this.realTimeData = realTimeData;
    }

    public int getCompanyZoneId() {
        return companyZoneId;
    }

    public void setCompanyZoneId(int companyZoneId) {
        this.companyZoneId = companyZoneId;
    }
}
