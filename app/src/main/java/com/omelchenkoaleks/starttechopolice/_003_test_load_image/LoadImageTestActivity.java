package com.omelchenkoaleks.starttechopolice._003_test_load_image;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.omelchenkoaleks.starttechopolice.R;
import com.omelchenkoaleks.starttechopolice._003_load_image_async_task.LoadImageActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
    Загружаем картинку из сети...
 */
public class LoadImageTestActivity extends AppCompatActivity {

    public static final String URL_IMAGE = "http://bestturizm.com.ua/images/cyprus_luchshie.jpg";
    private ImageView mImageView;
    private Executor mExecutor;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_test);

        mImageView = findViewById(R.id.test_load_image);

        mExecutor = Executors.newFixedThreadPool(3);
        mExecutor.execute(() -> {
            try {
                // используем загрузку картинки по ссылке url
                bitmap = BitmapFactory.decodeStream((InputStream) new URL(URL_IMAGE).getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
                публикуем картинку на главном потоке, ипользуя для этого
                специальный метод, определенный в классе Activity
             */
            LoadImageTestActivity.this.runOnUiThread(() ->
                mImageView.setImageBitmap(bitmap)
            );
        });
    }
}
