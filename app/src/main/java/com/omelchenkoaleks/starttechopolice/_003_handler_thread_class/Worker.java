package com.omelchenkoaleks.starttechopolice._003_handler_thread_class;

import android.os.Handler;
import android.os.HandlerThread;

/*
    В сравнении с предыдущим примером видно, что реализацию фонового потока можно
    сильно упростить если использовать class HandlerThread
 */
public class Worker extends HandlerThread {
    private static final String TAG = "Worker";

    private final Handler mHandler;

    public Worker() {
        super(TAG);
        start();
        // создаем Handler для отправки сообщений/задач в фоновый поток
        mHandler = new Handler(getLooper());
    }

    // отправляем задачу для выполнения в фоновом потоке
    public Worker execute(Runnable task) {
        mHandler.post(task);
        return this;
    }
}
