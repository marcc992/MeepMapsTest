package es.marcmauri.meepmaptest.maps;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanResource;
import es.marcmauri.meepmaptest.model.services.API;
import es.marcmauri.meepmaptest.model.services.ApiServices.ResourcesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsInteractor {

    private ResourcesService service = API.getResourcesServicesApi().create(ResourcesService.class);
    private Call<List<BeanResource>> allResourcesCall;

    interface OnMapListener {
        void onFetchingDataError(String error);

        void onFetchingAllResourcesSuccess(List<BeanResource> resourceList);
    }

    private String getLatLngString(LatLng location) {
        return String.valueOf(location.latitude) + ',' + location.longitude;
    }

    public void getAllServerData(String city, LatLng lowerLeft, LatLng upperRight, final OnMapListener listener) {
        allResourcesCall = service.getAllResourcesByCity(city, getLatLngString(lowerLeft), getLatLngString(upperRight));
        allResourcesCall.enqueue(new Callback<List<BeanResource>>() {
            @Override
            public void onResponse(Call<List<BeanResource>> call, Response<List<BeanResource>> response) {
                if (response.isSuccessful()) {
                    List<BeanResource> beanResources = response.body();
                    if (beanResources != null && !beanResources.isEmpty()) {
                        listener.onFetchingAllResourcesSuccess(beanResources);
                    } else {
                        listener.onFetchingDataError("No available data from server");
                    }
                } else {
                    listener.onFetchingDataError("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<BeanResource>> call, Throwable t) {
                listener.onFetchingDataError(t.getLocalizedMessage());
            }
        });
    }

    public void onDestroy() {
        if (allResourcesCall != null) {
            allResourcesCall.cancel();
        }
    }

}
