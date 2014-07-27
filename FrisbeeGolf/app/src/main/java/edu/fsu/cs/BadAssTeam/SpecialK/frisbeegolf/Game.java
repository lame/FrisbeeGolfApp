package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by lance on 7/25/14.
 */
public class Game extends Activity {

    // declaring variables
    private int holeNum, parNumber = 0, p1Throw=0, p2Throw=0, p3Throw=0, p4Throw=0;
    private TextView hole_Number, par_Number;
    private TextView p1, p2, p3, p4, p1_throw, p2_throw, p3_throw, p4_throw;
    private String player1, player2, player3, player4, course, hole_Num;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.course);

        // retrieving passed data from previous activity
        Intent newGame = getIntent();
        holeNum = newGame.getIntExtra("hole", 1);
        course = newGame.getStringExtra("course");
        player1 = newGame.getStringExtra("player1");
        player2 = newGame.getStringExtra("player2");
        player3 = newGame.getStringExtra("player3");
        player4 = newGame.getStringExtra("player4");

        // instantiating TextViews
        p1 = (TextView) findViewById(R.id.p1_Name);
        p2 = (TextView) findViewById(R.id.p2_Name);
        p3 = (TextView) findViewById(R.id.p3_Name);
        p4 = (TextView) findViewById(R.id.p4_Name);
        p1_throw = (TextView) findViewById(R.id.p1_throw);
        p2_throw = (TextView) findViewById(R.id.p2_throw);
        p3_throw = (TextView) findViewById(R.id.p3_throw);
        p4_throw = (TextView) findViewById(R.id.p4_throw);
        hole_Number = (TextView) findViewById(R.id.hole_Num);

        // updating text with input data
        p1.setText(player1);
        if("".equals(player2)){
            TableRow player2 = (TableRow) findViewById(R.id.playerRow2);
            player2.setVisibility(View.GONE);
        } else
            p2.setText(player2);
        if("".equals(player3)){
            TableRow player3 = (TableRow) findViewById(R.id.playerRow3);
            player3.setVisibility(View.GONE);
        } else
            p3.setText(player3);
        if("".equals(player4)){
            TableRow player4 = (TableRow) findViewById(R.id.playerRow4);
            player4.setVisibility(View.GONE);
        } else
            p4.setText(player4);
        hole_Num = Integer.toString(holeNum);
        hole_Number.setText(hole_Num);

        // instantiating and implementing add and minus buttons
        ((Button) findViewById(R.id.p1plus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                p1Throw++;
                p1_throw.setText(Integer.toString(p1Throw));
            }
        });
        ((Button) findViewById(R.id.p2plus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                p2Throw++;
                p2_throw.setText(Integer.toString(p2Throw));
            }
        });
        ((Button) findViewById(R.id.p3plus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                p3Throw++;
                p3_throw.setText(Integer.toString(p3Throw));
            }
        });
        ((Button) findViewById(R.id.p4plus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                p4Throw++;
                p4_throw.setText(Integer.toString(p4Throw));
            }
        });
        ((Button) findViewById(R.id.p1minus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                if(p1Throw > 0)
                    p1Throw--;
                p1_throw.setText(Integer.toString(p1Throw));
            }
        });
        ((Button) findViewById(R.id.p2minus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                if(p2Throw > 0)
                    p2Throw--;
                p2_throw.setText(Integer.toString(p2Throw));
            }
        });
        ((Button) findViewById(R.id.p3minus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                if(p3Throw > 0)
                    p3Throw--;
                p3_throw.setText(Integer.toString(p3Throw));
            }
        });
        ((Button) findViewById(R.id.p4minus)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                if(p4Throw > 0)
                    p4Throw--;
                p4_throw.setText(Integer.toString(p4Throw));
            }
        });

        // Moving to next or previous holes
        if(holeNum != 1)
            ((Button) findViewById(R.id.previous)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    holeNum--;
                    Intent nextHole = new Intent(Game.this, Game.class);
                    nextHole.putExtra("hole", holeNum);
                    nextHole.putExtra("course", course);
                    nextHole.putExtra("player1", player1);
                    nextHole.putExtra("player2", player2);
                    nextHole.putExtra("player3", player3);
                    nextHole.putExtra("player4", player4);
                    startActivityForResult(nextHole, 0);
                    finish();
                }
            });
        ((Button) findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                holeNum++;
                Intent nextHole = new Intent(Game.this, Game.class);
                nextHole.putExtra("hole", holeNum);
                nextHole.putExtra("course", course);
                nextHole.putExtra("player1", player1);
                nextHole.putExtra("player2", player2);
                nextHole.putExtra("player3", player3);
                nextHole.putExtra("player4", player4);
                startActivityForResult(nextHole, 0);
                finish();
            }
        });

    }

    // disables the back button
    @Override
    public void onBackPressed() {
    }

}