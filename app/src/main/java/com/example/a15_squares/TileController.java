package com.example.a15_squares;

import android.graphics.Color;
import android.service.quicksettings.Tile;
import android.view.MotionEvent;
import android.view.View;

public class TileController implements View.OnTouchListener, View.OnClickListener{

    private TileView[] tiles;
    private TileModel model;


    // This is the constructor for the tilecontroller class
    TileController(TileView[] tileArray){
        this.tiles = tileArray;

    }

    // this method handles touch events on specific tileviews
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(view instanceof TileView){
            TileView tileView = (TileView)view;
            int tileId = tileView.getTileId();
            // checks tile above
            if(tileId - 4 >= 0){
                if(model.getNumTile()[tileId - 4] == 0){
                    model.setTile(tileId - 4, model.getNumTile()[tileId]);
                    // puts zero into the tapped tile
                    model.setTile(tileId, 0);
                }
            }
            // checks tile below
            if(tileId + 4 <= 15){
                if(model.getNumTile()[tileId + 4] == 0){
                    // puts the tapped tile into the zero tile
                    model.setTile(tileId + 4, model.getNumTile()[tileId]);
                    // puts zero into the tapped tile
                    model.setTile(tileId, 0);
                }
            }

            // checks tile to the right
            if(tileId + 1 <= 15){
                if(model.getNumTile()[tileId + 1] == 0){
                    model.setTile(tileId + 1, model.getNumTile()[tileId]);
                    // puts zero into the tapped tile
                    model.setTile(tileId, 0);
                }
            }

            // checks tile to the left
            if(tileId - 1 >= 0){
                if(model.getNumTile()[tileId - 1] == 0){
                    model.setTile(tileId - 1, model.getNumTile()[tileId]);
                    // puts zero into the tapped tile
                    model.setTile(tileId, 0);
                }
            }
            model.setOrder(true);
            for (int i = 0; i < model.getNumTile().length - 1; i++){
                if (model.getNumTile()[i] != i + 1){
                    model.setOrder(false);
                    break;
                }
            }

            for(TileView tv : tiles){
                if(model.isOrder()) {
                    tv.textPaint.setColor(Color.GREEN);
                }
                tv.invalidate();
            }
        }
        return true;
    }

    public void setModel(TileModel model){
        this.model = model;
    }

    // this is called when the reset button is clicked
    @Override
    public void onClick(View view) {
        model.randomize();
        for(TileView tv : tiles){
            tv.invalidate();
        }
    }
}
