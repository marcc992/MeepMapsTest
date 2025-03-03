package es.marcmauri.meepmaptest.model.services.ApiServices;

import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanResource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ResourcesService {
    @GET("{cityName}/resources")
    Call<List<BeanResource>> getAllResourcesByCity(
            @Path("cityName") String cityName,
            @Query("lowerLeftLatLon") String lowerLeftLatLon,
            @Query("upperRightLatLon") String upperRightLatLon);
}
