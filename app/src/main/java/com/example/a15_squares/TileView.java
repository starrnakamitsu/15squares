package com.example.a15_squares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class TileView extends SurfaceView {

    Paint textPaint = new Paint();

    TileModel model;

    private int tileId; // the tile i am

    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    public int getTileId() {
        return tileId;
    }

    // this is a constructor that will create a tileview
    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(50);
    }

    // this method will draw the number on the tile
    @Override
    public void onDraw(Canvas c){
        if(model.getNumTile()[tileId] != 0) {
            c.drawText(String.valueOf(model.getNumTile()[tileId]), 100, 100, textPaint);
        }
    }

    // this method is to retrieve a reference to the model of the game
    public void setModel(TileModel model){
        this.model = model;
    }
}
