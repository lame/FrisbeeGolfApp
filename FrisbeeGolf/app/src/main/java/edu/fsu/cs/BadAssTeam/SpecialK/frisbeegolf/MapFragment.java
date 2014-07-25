package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by k on 7/24/14.
 */
public class MapFragment {

    private static GoogleMap map;
    private static View view;
    private static Double latitude, longitude;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        if (container == null)
            return null;

        view = (RelativeLayout) inflater.inflate(R.layout.config, container, false);

        latitude = 26.78;
        longitude = 72.56;

        setUp();

        return view;
    }

    public static void setUp(){
        if(map == null){
            map = ((SupportMapFragment)MainActivity.fragmentManager.findFragmentById(R.id.map_config))
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState){

    }

    public void onDestroyView(){

    }
}
