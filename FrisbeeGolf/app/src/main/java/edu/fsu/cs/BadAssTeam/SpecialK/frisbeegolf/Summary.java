package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by lance on 7/27/14.
 */
public class Summary extends Activity {

    private TextView p1, p2, p3, p4;
    private String player1, player2, player3, player4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.summary);

        retrieveIntent();

        p1 = (TextView) findViewById(R.id.p1_Name);
        p2 = (TextView) findViewById(R.id.p2_Name);
        p3 = (TextView) findViewById(R.id.p3_Name);
        p4 = (TextView) findViewById(R.id.p4_Name);

        updateTextView();

        ((Button) findViewById(R.id.Menu)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                finish();
            }
        });
    }

    public void retrieveIntent() {
        Bundle newGame = getIntent().getExtras();
        player1 = newGame.getString("player1");
        player2 = newGame.getString("player2");
        player3 = newGame.getString("player3");
        player4 = newGame.getString("player4");
    }

    public void updateTextView() {
        // updating names
        p1.setText(player1);
        if("".equals(player2)){
            TableRow player2 = (TableRow) findViewById(R.id.pRow2);
            player2.setVisibility(View.GONE);
        } else {
            p2.setText(player2);
        }
        if("".equals(player3)){
            TableRow player3 = (TableRow) findViewById(R.id.pRow3);
            player3.setVisibility(View.GONE);
        } else {
            p3.setText(player3);
        }
        if("".equals(player4)){
            TableRow player4 = (TableRow) findViewById(R.id.pRow4);
            player4.setVisibility(View.GONE);
        } else {
            p4.setText(player4);
        }
    }
}
