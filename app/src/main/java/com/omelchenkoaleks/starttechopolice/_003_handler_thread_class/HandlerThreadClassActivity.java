package com.omelchenkoaleks.starttechopolice._003_handler_thread_class;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.omelchenkoaleks.starttechopolice.R;
import com.omelchenkoaleks.starttechopolice._003_handler_thread.SimpleWorker;

public class HandlerThreadClassActivity extends AppCompatActivity {
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
    private HandlerThread mWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        mResultTextView = findViewById(R.id.result_from_handler_text_view);

        mWorker = new HandlerThread("Worker");
        mWorker.start();
        final Handler workerHandler = new Handler(mWorker.getLooper());


        // инициируем выполнение задач в фоновом потоке
        workerHandler.post(
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
        );

        workerHandler.post(
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
        );

        workerHandler.post(
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
        );

        workerHandler.post(
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
        );

        workerHandler.post(
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
}
