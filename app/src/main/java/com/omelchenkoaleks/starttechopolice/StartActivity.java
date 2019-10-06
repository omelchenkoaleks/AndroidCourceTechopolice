package com.omelchenkoaleks.starttechopolice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.starttechopolice._001_draw.DrawActivity;
import com.omelchenkoaleks.starttechopolice._001_introduction.MainActivity;
import com.omelchenkoaleks.starttechopolice._002_constraint.layout_constraintWidth_defaultActivity;
import com.omelchenkoaleks.starttechopolice._001_fire.FireActivity;
import com.omelchenkoaleks.starttechopolice._002_recycler_view.MovieActivity;
import com.omelchenkoaleks.starttechopolice._003_asynctask.GetImageActivity;
import com.omelchenkoaleks.starttechopolice._003_handler_thread.HandlerThreadActivity;
import com.omelchenkoaleks.starttechopolice._003_handler_thread_class.HandlerThreadClassActivity;
import com.omelchenkoaleks.starttechopolice._003_load_image_and_progress_bar.ProgressBarActivity;
import com.omelchenkoaleks.starttechopolice._003_load_image_async_task.LoadImageActivity;
import com.omelchenkoaleks.starttechopolice._003_test_load_image.LoadImageTestActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.introduction_button:
                Intent introductionIntent = new Intent(this, MainActivity.class);
                startActivity(introductionIntent);
                break;

            case R.id.layout_button:
                Intent layoutIntent = new Intent(this, layout_constraintWidth_defaultActivity.class);
                startActivity(layoutIntent);
                break;

            case R.id.recycler_view_button:
                Intent recyclerViewIntent = new Intent(this, MovieActivity.class);
                startActivity(recyclerViewIntent);
                break;

            case R.id.fire_button:
                Intent fireIntent = new Intent(this, FireActivity.class);
                startActivity(fireIntent);
                break;

            case R.id.draw_button:
                Intent drawIntent = new Intent(this, DrawActivity.class);
                startActivity(drawIntent);
                break;

            case R.id.handler_button:
                Intent handlerIntent = new Intent(this, HandlerThreadActivity.class);
                startActivity(handlerIntent);
                break;

            case R.id.handler_thread_button:
                Intent handlerThreadIntent = new Intent(this, HandlerThreadClassActivity.class);
                startActivity(handlerThreadIntent);
                break;

            case R.id.load_image_button:
                Intent loadImageIntent = new Intent(this, LoadImageActivity.class);
                startActivity(loadImageIntent);
                break;

            case R.id.test_load_image_button:
                Intent loadImageTestIntent = new Intent(this, LoadImageTestActivity.class);
                startActivity(loadImageTestIntent);
                break;

            case R.id.download_button:
                Intent downloadIntent = new Intent(this, GetImageActivity.class);
                startActivity(downloadIntent);
                break;

            case R.id.progress_bar_button:
                Intent progressBarIntent = new Intent(this, ProgressBarActivity.class);
                startActivity(progressBarIntent);
                break;
        }
    }
}
