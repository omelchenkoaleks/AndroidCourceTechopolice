package com.omelchenkoaleks.starttechopolice._002_constraint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.omelchenkoaleks.starttechopolice.R;

/*
    Chain - цепь
    если елементы привязаны последовательно друг к другу - они образуют цепь, цепь
    может существовать сама по себе, но и быть привязана к стронам родителя

    ВАЖНО: для того, чтобы установить тип цепи, нужно добавить атрибут первому из элементов цепи
        app:layout_constraintVertical_chainStyle
        app:layout_constraintHorizontal_chainStyle

    1, spread (по умолчанию) простая цепь распределяет все элменты равномерно с отступами от края радоителя
    2, spread_inside равномерно друг от друга, но отступ от родительского элемента отсутствует
    3, packed элементы расположены в центре цепи друг за другом
 */

public class layout_constraintHorizontal_chainStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_constraint_horizontal_chain_style);
    }
}
