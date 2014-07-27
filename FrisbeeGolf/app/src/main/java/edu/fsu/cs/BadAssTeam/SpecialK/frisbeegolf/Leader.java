package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;

/**
 * Created by lance on 7/25/14.
 */
public class Leader extends Activity {

    private LinearLayout leader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.leader);

        leader = (LinearLayout) findViewById(R.id.LeaderLayout);
        leader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
