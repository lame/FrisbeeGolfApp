package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Setup extends Activity {

    private EditText p1_Name;
    private EditText p2_Name;
    private EditText p3_Name;
    private EditText p4_Name;
    private Spinner spinner_View;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.config);

        // populate menu listView
        generateSpinner();
        p1_Name = (EditText)findViewById(R.id.p1name);
        p2_Name = (EditText)findViewById(R.id.p2name);
        p3_Name = (EditText)findViewById(R.id.p3name);
        p4_Name = (EditText)findViewById(R.id.p4name);
        final String player1 = p1_Name.getText().toString();
        final String player2 = p2_Name.getText().toString();
        final String player3 = p3_Name.getText().toString();
        final String player4 = p4_Name.getText().toString();
        final String selection = spinner_View.getSelectedItem().toString();
        ((Button) findViewById(R.id.start)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent newGame = new Intent(Setup.this, Game.class);
                newGame.putExtra("course", selection);
                newGame.putExtra("player1", player1);
                newGame.putExtra("player2", player2);
                newGame.putExtra("player3", player3);
                newGame.putExtra("player4", player4);
                startActivityForResult(newGame, 0);
            }
        });
    }

    private void generateSpinner() {
        // content of the Menu ListView
        String[] spinner_items = {"Tom Brown Park", "Jack McLean Park"};

        // Adapter
        ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinner_items);

        // Configuring the list view
        spinner_View = (Spinner) findViewById(R.id.spinner);
        spinner_View.setAdapter(items);
    }
}