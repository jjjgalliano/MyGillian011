package com.example.user.gillian01.model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2016/8/24.
 */
public class OwnedPokemonDataManager {

    Context mcontext  ;// system app defalut context ; access system service
    ArrayList<OwnedPokemonInfo> ownedPokemonInfos = null;

    public OwnedPokemonDataManager(Context context)
    {
        mcontext = context;


    }

    public void loadListViewData(){
        ownedPokemonInfos = new ArrayList<>();

        BufferedReader reader;
        String line = null;
        String[] datafields = null;

        try{
                reader = new BufferedReader(new InputStreamReader(mcontext.getAssets().open("pokemon_data.csv")));

            while((line = reader.readLine()) != null)
            {
                datafields = line.split(",");
                ownedPokemonInfos.add(construcrPokemonInfo(datafields));
            }
            reader.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static final int skillStartIndex =8;
    private OwnedPokemonInfo construcrPokemonInfo(String[] dataFileds)
    {
        OwnedPokemonInfo ownedPokemonInfo = new OwnedPokemonInfo();
        ownedPokemonInfo.pokemonId =Integer.valueOf(dataFileds[0]);
        ownedPokemonInfo.name = dataFileds[2];
        ownedPokemonInfo.level = Integer.valueOf(dataFileds[3]);
        ownedPokemonInfo.currentHP = Integer.valueOf(dataFileds[4]);
        ownedPokemonInfo.maxHP = Integer.valueOf(dataFileds[5]);
        ownedPokemonInfo.type_1= Integer.valueOf(dataFileds[6]);
        ownedPokemonInfo.type_2 = Integer.valueOf(dataFileds[7]);

        for(int i =skillStartIndex; i<dataFileds.length;i++ )
        {
            ownedPokemonInfo.skills[i-skillStartIndex] = dataFileds[i];

        }
        Log.d("testDM", ownedPokemonInfo.name+","+ ownedPokemonInfo.level+","+ownedPokemonInfo.type_1+","+ownedPokemonInfo.type_2+ ownedPokemonInfo.currentHP+","+ownedPokemonInfo.maxHP+","+ Arrays.toString(ownedPokemonInfo.skills));
        return ownedPokemonInfo;
    }

    public ArrayList<OwnedPokemonInfo> getOwnedPokemonInfos() {
        return ownedPokemonInfos;
    }

}
