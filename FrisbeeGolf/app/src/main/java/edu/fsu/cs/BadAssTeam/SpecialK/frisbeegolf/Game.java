package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lance on 7/25/14.
 */
public class Game extends Activity {

    // declaring variables
    private fbGolf DGolf;
    private int holeNum, parNumber = 0, course = 0, p1Throw=0, p2Throw=0, p3Throw=0, p4Throw=0;
    private TextView p1, p2, p3, p4, p1_throw, p2_throw, p3_throw, p4_throw, hole_Number, par_Number;
    private String player1, player2, player3, player4, hole_Num;
    private int[][] mapArray = {{R.drawable.tbp1, R.drawable.tbp2, R.drawable.tbp3, R.drawable.tbp4, R.drawable.tbp5, R.drawable.tbp6, R.drawable.tbp7, R.drawable.tbp8, R.drawable.tbp9, R.drawable.tbp10,
            R.drawable.tbp11, R.drawable.tbp12, R.drawable.tbp13, R.drawable.tbp14, R.drawable.tbp15, R.drawable.tbp16, R.drawable.tbp17, R.drawable.tbp18},{R.drawable.jmp1, R.drawable.jmp2, R.drawable.jmp3,
            R.drawable.jmp4, R.drawable.jmp5, R.drawable.jmp6, R.drawable.jmp7, R.drawable.jmp8, R.drawable.jmp9, R.drawable.jmp10, R.drawable.jmp11, R.drawable.jmp12, R.drawable.jmp13, R.drawable.jmp14,
            R.drawable.jmp15, R.drawable.jmp16, R.drawable.jmp17, R.drawable.jmp18, R.drawable.jmp19, R.drawable.jmp20, R.drawable.jmp21, R.drawable.jmp22, R.drawable.jmp23, R.drawable.jmp24}};
    private ImageView map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.course);

        // retrieving passed data from previous activity
        retrieveIntent();

        // instantiating Views
        p1 = (TextView) findViewById(R.id.p1_Name);
        p2 = (TextView) findViewById(R.id.p2_Name);
        p3 = (TextView) findViewById(R.id.p3_Name);
        p4 = (TextView) findViewById(R.id.p4_Name);
        p1_throw = (TextView) findViewById(R.id.p1_throw);
        p2_throw = (TextView) findViewById(R.id.p2_throw);
        p3_throw = (TextView) findViewById(R.id.p3_throw);
        p4_throw = (TextView) findViewById(R.id.p4_throw);
        hole_Number = (TextView) findViewById(R.id.hole_Num);
        par_Number = (TextView) findViewById(R.id.par_Num);
        map = (ImageView) findViewById(R.id.holeMap);

        // updating text with input data
        updateTextView();

        hole_Num = Integer.toString(holeNum);
        hole_Number.setText(hole_Num);

        // initializing linked-list for storage
        DGolf = new fbGolf(course, player1, player2, player3, player4);

        // update throws
        updateThrows();

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
            backAction();
        else {
            ((Button) findViewById(R.id.previous)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    Toast.makeText(Game.this,
                            "You have reached the first hole.\nGo to summary to exit game.", Toast.LENGTH_LONG).show();
            }});
        }
        if(holeNum != DGolf.getHoles(course)) {
            nextAction();
        } else {
            ((Button) findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View V) {
                    Toast.makeText(Game.this,
                            "You have reached the last hole.\nGo to summary to end game.", Toast.LENGTH_LONG).show();
                }
            });
        }

        // update image
        if(course == 1)
            map.setImageResource(mapArray[course - 1][holeNum - 1]);
        else if (course == 2)
            map.setImageResource(mapArray[course - 1][holeNum - 1]);

        ((Button) findViewById(R.id.summary)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent endGame = new Intent(Game.this, Summary.class);
                //endGame.putExtra("current", holeNum);
                endGame.putExtra("player1", player1);
                endGame.putExtra("player2", player2);
                endGame.putExtra("player3", player3);
                endGame.putExtra("player4", player4);
                startActivityForResult(endGame, 0);
                finish();
            }
        });
    }

    // disables the back button
    @Override
    public void onBackPressed() {
    }

    public void retrieveIntent() {
        Bundle newGame = getIntent().getExtras();
        holeNum = newGame.getInt("hole");
        course = newGame.getInt("course");
        player1 = newGame.getString("player1");
        player2 = newGame.getString("player2");
        player3 = newGame.getString("player3");
        player4 = newGame.getString("player4");
    }

    public void updateTextView() {
        // updating names
        p1.setText(player1);
        if("".equals(player2)){
            TableRow player2 = (TableRow) findViewById(R.id.playerRow2);
            player2.setVisibility(View.GONE);
        } else {
            p2.setText(player2);
        }
        if("".equals(player3)){
            TableRow player3 = (TableRow) findViewById(R.id.playerRow3);
            player3.setVisibility(View.GONE);
        } else {
            p3.setText(player3);
        }
        if("".equals(player4)){
            TableRow player4 = (TableRow) findViewById(R.id.playerRow4);
            player4.setVisibility(View.GONE);
        } else {
            p4.setText(player4);
        }
    }

    public void backAction() {
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
    }

    public void nextAction() {
        ((Button) findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                holeNum++;
                setThrows();
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

    public void setThrows() {
        DGolf.setPutts(0,holeNum-1,p1Throw);
        DGolf.setPutts(1,holeNum-1,p2Throw);
        DGolf.setPutts(2,holeNum-1,p3Throw);
        DGolf.setPutts(3,holeNum-1,p4Throw);
    }

    public void updateThrows() {
        par_Number.setText(Integer.toString(DGolf.getPar(course,holeNum-1)));
        p1Throw=DGolf.getPutts(0,holeNum-1);
        if(p1Throw != 0) {
            p1_throw.setText(Integer.toString(p1Throw));
        }
        p2Throw=DGolf.getPutts(1,holeNum-1);
        if(p2Throw != 0) {
            p2_throw.setText(Integer.toString(p2Throw));
        }
        p3Throw=DGolf.getPutts(2,holeNum-1);
        if(p3Throw != 0) {
            p3_throw.setText(Integer.toString(p3Throw));
        }
        p4Throw=DGolf.getPutts(3,holeNum-1);
        if(p4Throw != 0) {
            p4_throw.setText(Integer.toString(p4Throw));
        }
    }
}