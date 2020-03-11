package es.marcmauri.meepmaptest.maps;

import android.content.Context;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import es.marcmauri.meepmaptest.R;
import es.marcmauri.meepmaptest.model.beans.BeanResource;
import es.marcmauri.meepmaptest.model.markers.ResourceMarker;

import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BIKE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_ONE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_THREE;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.BUS_TWO;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.ECOOLTRA;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.EMOV;
import static es.marcmauri.meepmaptest.model.common.ResourceTypes.TAXI;

public class MapsPresenter implements MapsInteractor.OnMapListener {

    private MapsView mapsView;
    private MapsInteractor mapsInteractor;
    private Context appContext;

    public MapsPresenter(MapsView mapsView, MapsInteractor mapsInteractor, Context appContext) {
        this.mapsView = mapsView;
        this.mapsInteractor = mapsInteractor;
        this.appContext = appContext;
    }

    public void showAllServices() {
        if (mapsView != null) {
            mapsView.showProgress();
        }

        // TODO: Get the selected region on Google Map to get the accurate data (not for technical test)
        mapsInteractor.getAllResourcesData(
                "lisboa", new LatLng(38.711046, -9.160096),
                new LatLng(38.739429, -9.137115), this);
    }


    @Override
    public void onFetchingDataError(String error) {
        mapsView.showError(appContext.getString(R.string.error_text_with_colon) + error);
    }

    @Override
    public void onFetchingDataEmpty() {
        mapsView.showError(appContext.getString(R.string.info_text_empty_data));
    }

    @Override
    public void onFetchingAllResourcesSuccess(List<BeanResource> resourceList) {
        if (mapsView != null) {
            // First, create a list of markers with the interested data from resources
            List<ResourceMarker> actualMarkers = new ArrayList<>();

            for (BeanResource resource : resourceList) {
                String description;
                BitmapDescriptor bitmapDescriptor;
                switch (resource.getCompanyZoneId()) {
                    case BIKE:
                        description = appContext.getString(R.string.resource_info_service_bike);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE);
                        break;
                    case BUS_ONE:
                        description = appContext.getString(R.string.resource_info_service_bus_a);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);
                        break;
                    case BUS_TWO:
                        description = appContext.getString(R.string.resource_info_service_bus_b);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA);
                        break;
                    case BUS_THREE:
                        description = appContext.getString(R.string.resource_info_service_bus_c);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE);
                        break;
                    case ECOOLTRA:
                        description = appContext.getString(R.string.resource_info_service_ecooltra);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
                        break;
                    case EMOV:
                        description = appContext.getString(R.string.resource_info_service_emov);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE);
                        break;
                    case TAXI:
                        description = appContext.getString(R.string.resource_info_service_cab);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW);
                        break;
                    default:
                        description = appContext.getString(R.string.resource_info_service_unknown);
                        bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);
                }

                actualMarkers.add(new ResourceMarker(
                        resource.getId(),
                        resource.getName(),
                        description,
                        new LatLng(resource.getY(), resource.getX()),
                        bitmapDescriptor));
            }

            // Finally, call the "painter" in the view
            mapsView.showAllMarkers(actualMarkers);

            mapsView.hideProgress();
        }
    }


    public void onDestroy() {
        mapsView = null;
        mapsInteractor.onDestroy();
    }

}
