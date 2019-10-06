package com.omelchenkoaleks.starttechopolice._003_handler_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.starttechopolice.R;

/*
    Цель примера показать - Как можно реализовать выполнение задач в потоке, который
    не является главным, т.е. в фоновом (worker) потоке.

    Инициировать выполнение задачи бдуем в главном потоке и в нем же отображать результат.

    Для взаимодействия между потоками используем Handler.
 */
public class HandlerThreadActivity extends AppCompatActivity {

    private final Handler mHandler = new Handler(Looper.getMainLooper()) {
        // вызывается в главном потоке
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // отображает результат
            mResultTextView.setText((String) msg.obj);
        }
    };

    private TextView mResultTextView;

    // наш фоновый поток для выполнения задач
    private SimpleWorker mWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        mResultTextView = findViewById(R.id.result_from_handler_text_view);

        // создаем фоновый поток
        mWorker = new SimpleWorker();


        /* ---------- инициируем выполнение задач в фоновом потоке ---------- */

        mWorker.execute(
                // вызывается в фоновом потоке
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // передаем результат в главный поток через handler
                        Message message = Message.obtain();
                        message.obj = "Task 1 completed";
                        mHandler.sendMessage(message);
                    }
                }
        ).execute(
                // вызывается в фоновом потоке
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // передаем результат в главный поток через handler
                        Message message = Message.obtain();
                        message.obj = "Task 2 completed";
                        mHandler.sendMessage(message);
                    }
                }
        ).execute(
                // вызывается в фоновом потоке
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // передаем результат в главный поток через handler
                        Message message = Message.obtain();
                        message.obj = "Task 3 completed";
                        mHandler.sendMessage(message);
                    }
                }
        ).execute(
                // вызывается в фоновом потоке
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // передаем результат в главный поток через handler
                        Message message = Message.obtain();
                        message.obj = "Task 4 completed";
                        mHandler.sendMessage(message);
                    }
                }
        ).execute(
                // вызывается в фоновом потоке
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // передаем результат в главный поток через handler
                        Message message = Message.obtain();
                        message.obj = "Task 5 completed";
                        mHandler.sendMessage(message);
                    }
                }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // не забываем завершить наш фоновый поток
        mWorker.quit();
    }
}
