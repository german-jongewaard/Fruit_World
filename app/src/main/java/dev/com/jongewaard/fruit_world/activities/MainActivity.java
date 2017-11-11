package dev.com.jongewaard.fruit_world.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import dev.com.jongewaard.fruit_world.R;
import dev.com.jongewaard.fruit_world.models.Fruit;

/**
 * Created by german on 10-11-17.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //ListView, GridView y Adapters.
    private ListView listView;
    private GridView gridView;

    //Lista de nuestro modelo, fruta.


    private MenuItem itemListView;
    private MenuItem itemGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mostrar icono. (El método esta mas abajo)
        this.enforceIconBar();

        this.listView = (ListView) findViewById(R.id.listView);
        //this.gridView = (GridView) findViewById(R.id.gridView);

        //Adjuntando el mismo método click para ambos.
        this.listView.setOnItemClickListener(this);
        this.gridView.setOnItemClickListener(this);
    }

    //Método para mostrar el Icono en la barra de menú.
    private void enforceIconBar() {
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private List<Fruit> getAllFruits(){
        List<Fruit> list = new ArrayList<Fruit>(){{

            add(new Fruit("Banana", R.mipmap.ic_banana, "Gran Canaria"));

        }};
        return list;
    }
}
