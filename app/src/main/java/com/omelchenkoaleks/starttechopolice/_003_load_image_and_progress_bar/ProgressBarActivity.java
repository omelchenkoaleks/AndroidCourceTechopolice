package com.omelchenkoaleks.starttechopolice._003_load_image_and_progress_bar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.starttechopolice.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ProgressBarActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String IMAGE_URL =
            "http://bestturizm.com.ua/images/chehiya-dostoprimechatelnosti-02-2.jpg";
    private ProgressBar mProgressBar;
    private ImageView mImageView;
    private Button mButton;
    LoadingImageTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        mTask = new LoadingImageTask();
        mImageView = findViewById(R.id.imageView2);
        mProgressBar = findViewById(R.id.id_progress);
        mProgressBar.setVisibility(View.INVISIBLE);
        mButton = findViewById(R.id.button3);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mProgressBar.setVisibility(View.VISIBLE);
            mTask.execute();
    }

    private class LoadingImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            return getImageByUrl(IMAGE_URL);
        }

        private Bitmap getImageByUrl(String url) {
            Bitmap image = null;
            try {
                image = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
                Thread.sleep(3000); // чтобы посмотреть ProgressBar )))
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
            mProgressBar.setVisibility(View.INVISIBLE);
        }
    }
}
