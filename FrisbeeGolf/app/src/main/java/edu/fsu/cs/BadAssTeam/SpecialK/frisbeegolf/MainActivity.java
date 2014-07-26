package edu.fsu.cs.BadAssTeam.SpecialK.frisbeegolf;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // populate menu listView
        generateMenuList();
        clickMenuList();

    }

    private void generateMenuList() {
        // content of the Menu ListView
        String[] menu_items = {"Select Course", "Leaderboard", "About"};

        // Adapter
        ArrayAdapter<String> items = new ArrayAdapter<String>(this, R.layout.menulist, menu_items);

        // Configuring the list view
        ListView menu_ListView = (ListView) findViewById(R.id.menuListView);
        menu_ListView.setAdapter(items);
    }

    private void clickMenuList() {
        ListView menu_ListView = (ListView) findViewById(R.id.menuListView);
        menu_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                switch( position ) {
                    case 0:
                        Intent Setup = new Intent(MainActivity.this, Setup.class);
                        startActivityForResult(Setup, 0);
                        break;
                    case 1:
                        Intent Leader = new Intent(MainActivity.this, Leader.class);
                        startActivityForResult(Leader, 0);
                        break;
                    case 2:
                        Intent About = new Intent(MainActivity.this, About.class);
                        startActivityForResult(About, 0);
                        break;
                }

            }
        });
    }
}


