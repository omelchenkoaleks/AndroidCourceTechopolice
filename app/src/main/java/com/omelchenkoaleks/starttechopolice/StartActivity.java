package com.omelchenkoaleks.starttechopolice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.starttechopolice._001_draw.DrawActivity;
import com.omelchenkoaleks.starttechopolice._001_introduction.MainActivity;
import com.omelchenkoaleks.starttechopolice._002_constraint.layout_constraintWidth_defaultActivity;
import com.omelchenkoaleks.starttechopolice._001_fire.FireActivity;
import com.omelchenkoaleks.starttechopolice._003_recycler_view.MovieActivity;

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
        }
    }
}
