package com.omelchenkoaleks.starttechopolice._003_load_image_async_task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.starttechopolice.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/*
    https://webnewsite.ru/mnogopotochnost-v-android-chast-1-asynctask-asinhronnaya-zagruzka-izobrazheniy-iz-internet/
 */
public class LoadImageActivity extends AppCompatActivity {

    public static final String IMAGE_URL =
            "http://bestturizm.com.ua/images/chehiya-dostoprimechatelnosti-02-2.jpg";

    private LoadingImageTask mLoadingTask;
    private ImageView mImageView;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_load_image);

        mImageView = findViewById(R.id.single_image_view);

        loadImage();
    }

    private void loadImage() {
        if (mLoadingTask == null || mLoadingTask.getStatus().equals(AsyncTask.Status.FINISHED)) {
            mLoadingTask = new LoadingImageTask();
            mLoadingTask.execute(IMAGE_URL);
        }
    }

    public void showImageOnClick(View view) {
        mImageView.setImageBitmap(image);
    }

    private class LoadingImageTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            try {
                image = getImageByURL(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Bitmap getImageByURL(String url) throws IOException {
            Bitmap image = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
            return image;
        }
    }
}
