package dev.com.jongewaard.fruit_world.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.com.jongewaard.fruit_world.R;
import dev.com.jongewaard.fruit_world.adapters.FruitAdapter;
import dev.com.jongewaard.fruit_world.models.Fruit;

/**
 * Created by german on 10-11-17.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //ListView, GridView y Adapters.
    private ListView listView;
    private GridView gridView;
    private FruitAdapter adapterListView;
    private FruitAdapter adapterGridView;

    // Lista de nuestro modelo, fruta
    private List<Fruit> fruits;

    // Items en el option menu
    private MenuItem itemListView;
    private MenuItem itemGridView;

    // Variables
    private int counter = 0;
    private final int SWITCH_TO_LIST_VIEW = 0;
    private final int SWITCH_TO_GRID_VIEW = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mostrar icono. (El método esta mas abajo)
        this.enforceIconBar();

        this.fruits = getAllFruits();

        //los tomo del activity_main.xml
        this.listView = (ListView) findViewById(R.id.listView);
        this.gridView = (GridView) findViewById(R.id.gridView);

        // Adjuntando el mismo método click para ambos
        this.listView.setOnItemClickListener(this);
        this.gridView.setOnItemClickListener(this);

        this.adapterListView = new FruitAdapter(this, R.layout.list_view_item_fruit, fruits);
        this.adapterGridView = new FruitAdapter(this, R.layout.grid_view_item_fruit, fruits);

        this.listView.setAdapter(adapterListView);
        this.gridView.setAdapter(adapterGridView);

        // Registrar el context menu para ambos
        registerForContextMenu(this.listView);
        registerForContextMenu(this.gridView);
    }

    //Método para mostrar el Icono en la barra de menú.
    private void enforceIconBar() {
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.clickFruit(fruits.get(position));

    }

    private void clickFruit(Fruit fruit) {
        if(fruit.getOrigin().equals("Unknown"))
            Toast.makeText(this, "Sorry we don't have many info about " + fruit.getName(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "The best fruit from " + fruit.getOrigin() + " is " + fruit.getName(), Toast.LENGTH_SHORT).show();
    }

    private List<Fruit> getAllFruits(){
        List<Fruit> list = new ArrayList<Fruit>(){{

            add(new Fruit("Banana", R.mipmap.ic_banana, "Gran Canaria"));

        }};
        return list;
    }
}
