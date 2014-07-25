package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.support.v4.app.Fragment;
import android.support.v4.app.*;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by k on 7/24/14.
 */
public class MapFragment {

    private static GoogleMap map;
    private static View view;
    private static Double latitude, longitude;

    private final LatLng LOCATION_TOMBROWN = new LatLng(30.4468, 84.2146);
    private final LatLng LOCATION_JACKMCLEAN = new LatLng(30.406389,-84.272500);

/*
    @Override
    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
        map = ((MapFragment) getSupportFragmentManager.findFragmentById(R.id.map_config)).getMap();

        map.addMarker(new MarkerOptions().position(LOCATION_TOMBROWN).title("Tom Brown Frisbee Golf"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflater(R.menu.main, menu);
        return true;
    }

    public void onClick_City(View v) {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_TOMBROWN, 9);
        map.animateCamera(update);
    }
    public void onClick_TOMBROWN(View v){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_TOMBROWN, 14);
        map.animateCamera(update);
    }
    public void onClick_JACKMCLEAN(View v){
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_JACKMCLEAN, 16);
        map.animateCamera(update);
    }


*/
}
