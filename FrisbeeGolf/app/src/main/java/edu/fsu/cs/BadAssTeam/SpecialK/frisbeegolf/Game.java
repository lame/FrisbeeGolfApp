package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by lance on 7/25/14.
 */
public class Game extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.course);
    }

    // disables the back button
    @Override
    public void onBackPressed() {
    }

}