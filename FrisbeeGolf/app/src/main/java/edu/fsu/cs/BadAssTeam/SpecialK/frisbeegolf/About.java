package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by lance on 7/25/14.
 */
public class About extends Activity {

    private LinearLayout about;
    private TextView aboutText;
    private TextView versionText;
    private TextView supportText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about);

        aboutText = (TextView) findViewById(R.id.About);
        aboutText.setSingleLine(false);
        versionText = (TextView) findViewById(R.id.Version);
        versionText.setSingleLine(false);
        supportText = (TextView) findViewById(R.id.Support);
        supportText.setSingleLine(false);

        aboutText.setText ("DGolf is a disc golf scorecard app for all courses located in"+
                " Tallahassee. This apps allows a party up to four players to keep track of throws.");
        versionText.setText ("Current version: v1.0\nRelased Date: 25.7.2014");
        supportText.setText ("Jeffrey Kuang - jk13e@my.fsu.edu\n"+
                "Ryan Kuhl - rkk09c@my.fsu.edu");

        about = (LinearLayout) findViewById(R.id.AboutLayout);
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
