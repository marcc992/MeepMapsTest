package es.marcmauri.meepmaptest.maps;

import es.marcmauri.meepmaptest.model.services.API;
import es.marcmauri.meepmaptest.model.services.ApiServices.ResourcesService;
import retrofit2.Call;

import java.util.List;

import es.marcmauri.meepmaptest.model.beans.BeanApiResource;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsInteractor {

    private ResourcesService service = API.getResourcesServicesApi().create(ResourcesService.class);
    private Call<List<BeanApiResource>> resourcesCall;

    interface OnMapListener {
        void onFetchingDataError(String error);
        void onFetchingAllDataSuccess(List<BeanApiResource> serverObjects);
    }


    public void getAllServerData(final OnMapListener listener) {

        resourcesCall = service.getResourcesByCity("lisboa", "38.711046,-9.160096", "38.739429,-9.137115");
        resourcesCall.enqueue(new Callback<List<BeanApiResource>>() {
            @Override
            public void onResponse(Call<List<BeanApiResource>> call, Response<List<BeanApiResource>> response) {
                if (response.isSuccessful()) {
                    List<BeanApiResource> beanResources = response.body();
                    if (beanResources != null && !beanResources.isEmpty()) {
                        listener.onFetchingAllDataSuccess(beanResources);
                    } else {
                        listener.onFetchingDataError("No available data from server");
                    }
                } else {
                    listener.onFetchingDataError("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<BeanApiResource>> call, Throwable t) {
                listener.onFetchingDataError(t.getLocalizedMessage());
            }
        });
    }

    public void onDestroy() {
        if (resourcesCall != null) {
            resourcesCall.cancel();
        }
    }
}
