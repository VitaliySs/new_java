package com.example.androidgames.myframework;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

public class BitmapTest extends Activity {
    class RenderView extends View{
        Bitmap ico565;
        Bitmap ico4444;
        Rect dst = new Rect();

        public RenderView(Context context){
            super(context);

            try {
                AssetManager assetManager = context.getAssets();
                InputStream inputStream = assetManager.open("icon.png");
                ico565 = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                Log.d("BitmapText", "icon.png format: " + ico565.getConfig());

                inputStream = assetManager.open("icon.png");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                ico4444 = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
                Log.d("BitmapText", "icon.png format: " + ico4444.getConfig());
            }catch (IOException e){

            }finally {

            }
        }

        protected void onDraw(Canvas canvas){
            dst.set(50, 50, 350, 350);
            canvas.drawBitmap(ico565, null, dst, null);
            canvas.drawBitmap(ico4444, 100, 100, null);
            invalidate();
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(new RenderView(this));
    }
}
