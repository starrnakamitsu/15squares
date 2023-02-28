package com.example.a15_squares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.widget.Button;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This gets a reference to all of the TileView objects
        TileView tile1 = findViewById(R.id.tile1);
        TileView tile2 = findViewById(R.id.tile2);
        TileView tile3 = findViewById(R.id.tile3);
        TileView tile4 = findViewById(R.id.tile4);
        TileView tile5 = findViewById(R.id.tile5);
        TileView tile6 = findViewById(R.id.tile6);
        TileView tile7 = findViewById(R.id.tile7);
        TileView tile8 = findViewById(R.id.tile8);
        TileView tile9 = findViewById(R.id.tile9);
        TileView tile10 = findViewById(R.id.tile10);
        TileView tile11 = findViewById(R.id.tile11);
        TileView tile12 = findViewById(R.id.tile12);
        TileView tile13 = findViewById(R.id.tile13);
        TileView tile14 = findViewById(R.id.tile14);
        TileView tile15 = findViewById(R.id.tile15);
        TileView tile16 = findViewById(R.id.tile16);

        // This puts all of the TileViews into an array for easy reference
        TileView tileArray[] = {tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9,
            tile10, tile11, tile12, tile13, tile14, tile15, tile16};

        // This creates a model object for our game
        TileModel model = new TileModel();

        // This creates the controller with a reference to all of the TileViews
        TileController controller = new TileController(tileArray);
        controller.setModel(model);

        Button button = findViewById(R.id.Reset);
        button.setOnClickListener(controller);

        // This loop sets the on touch listener for all of the views and a reference to the model
        for(int i = 0; i < tileArray.length; i++) {
            tileArray[i].setOnTouchListener(controller);
            tileArray[i].setModel(model);
            tileArray[i].setTileId(i);
        }

    }
}