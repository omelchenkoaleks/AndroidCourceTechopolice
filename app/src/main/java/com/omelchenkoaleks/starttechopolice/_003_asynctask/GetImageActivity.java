package com.omelchenkoaleks.starttechopolice._003_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.omelchenkoaleks.starttechopolice.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetImageActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String IMAGE_URL =
            "http://bestturizm.com.ua/images/chehiya-dostoprimechatelnosti-02-2.jpg";
    private ImageView mImageView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_load_image);

        mImageView = findViewById(R.id.single_image_view);
        mButton = findViewById(R.id.button2);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DownloadImageTask task = new DownloadImageTask();
        task.execute();
    }

    private class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            return loadingImageByUrl(IMAGE_URL);
        }

        private Bitmap loadingImageByUrl(String string) {
            Bitmap image = null;
            try {
                image = BitmapFactory.decodeStream((InputStream) new URL(string).getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
