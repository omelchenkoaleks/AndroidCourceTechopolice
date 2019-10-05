package com.omelchenkoaleks.starttechopolice._003_handler_thread;

import android.util.Log;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/*
    реализация фонового потока
 */
public class SimpleWorker extends Thread {
    private static final String TAG = "SimpleWorker";

    // флаг завершения потока
    private final AtomicBoolean isAlive = new AtomicBoolean(true);

    /*
        очередь из задач
        используется потокобезопасная реализация очереди
        поскольку доступ к ней осуществляется из разных потоков
     */
    private final ConcurrentLinkedQueue<Runnable> mQueue = new ConcurrentLinkedQueue<>();

    public SimpleWorker() {
        super(TAG);
        // сразу же стартуем поток
        start();
    }

    @Override
    public void run() {
        /*
            выполняем бесконечный цикл выборки сообщений до тех пор,
            пока не будет вызван метод quit()
         */
        while (isAlive.get()) {
            Runnable task = mQueue.poll();
            if (task != null) {
                // выполняем задачу (диспетчируем сообщение)
                task.run();
            }
        }
        Log.d(TAG, "run: Simple Worker Terminated");
    }

    // инициируем выполнение задачи (постановкой в очередь)
    public SimpleWorker execute(Runnable task) {
        mQueue.add(task);
        return this;
    }

    // просим завершить работу
    public void quit() {
        isAlive.set(false);
    }
}
