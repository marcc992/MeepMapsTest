package es.marcmauri.meepmaptest.model.markers;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

public class ResourceMarkerRenderer extends DefaultClusterRenderer<ResourceMarker> {

    public ResourceMarkerRenderer(Context context, GoogleMap map, ClusterManager<ResourceMarker> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(ResourceMarker item, MarkerOptions markerOptions) {
        super.onBeforeClusterItemRendered(item, markerOptions);
        markerOptions.icon(item.getMarkerDescriptor());
    }
}