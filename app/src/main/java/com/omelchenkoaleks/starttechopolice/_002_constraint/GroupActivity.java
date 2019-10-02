package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.omelchenkoaleks.starttechopolice.R;

/*
    Group позволяет скрывать или показывать элементы одновременно, не перебирая их все по очереди
 */
public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Group group = findViewById(R.id.group_text_view);
        group.setVisibility(View.INVISIBLE); // срываем сразу все добавленные в группу

    }
}
