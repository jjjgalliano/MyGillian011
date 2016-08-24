package com.example.user.gillian01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.gillian01.model.OwnedPokemonDataManager;
import com.example.user.gillian01.model.OwnedPokemonInfo;

import java.util.ArrayList;

public class PokemonListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        OwnedPokemonDataManager dataManager = new OwnedPokemonDataManager(this); // activity can be as context
        dataManager.loadListViewData();

        ArrayList<OwnedPokemonInfo> ownedPokemonInfos = dataManager.getOwnedPokemonInfos();

        ArrayList<String> pokemonNames = new ArrayList<>();
        for(OwnedPokemonInfo ownedPokemonInfo : ownedPokemonInfos)
        {
            pokemonNames.add(ownedPokemonInfo.name);
        }

        ListView listView =(ListView)findViewById(R.id.listView); //??
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                pokemonNames);

        listView.setAdapter(arrayAdapter);

    }
}
