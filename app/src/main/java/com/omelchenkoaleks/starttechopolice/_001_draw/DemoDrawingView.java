package com.omelchenkoaleks.starttechopolice._001_draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DemoDrawingView extends View {
//    private final Paint mPaint = new Paint();
//
//    public DemoDrawingView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        int width = getWidth();
//        int height = getHeight();

        // Will draw in rect (0,0) - (width, height)

        // заливка цветом
//        canvas.drawColor(Color.BLUE);

        // прямоугольники
//        mPaint.setColor(Color.GREEN);
//        final int size = 300;
//        for (int x = 0; x < width; x += size) {
//            for (int y = 0; y < height; y += size) {
//                mPaint.setColor(0x00ffffff & (1257823419 * x + 2118746214 * y) | 0xff000000);
//                canvas.drawRect(x, y, x + size, y + size, mPaint);
//            }
//        }

        // круги
//        int centerX = width / 2;
//        int centerY = height / 2;
//        int padding = 50;
//        int minSide = Math.min(width, height);
//        int contentSize = minSide - 2 * padding;
//        int overlap = 180;
//        int radius = (contentSize + overlap) / 4;
//        int dist = 2 * radius - overlap;
//
//        float x1 = centerX - dist / 2;
//        float x2 = centerX + dist / 2;
//        float x3 = centerX;
//
//        float d = dist / 2 / (float) Math.sqrt(3f);
//        float y1 = centerY + d;
//        float y2 = y1;
//        float y3 = centerY - 2 * d;
//
//        mPaint.setColor(Color.YELLOW & 0x7fffffff);
//        canvas.drawCircle(x1, y1, radius, mPaint);
//        mPaint.setColor(Color.MAGENTA & 0x7fffffff);
//        canvas.drawCircle(x2, y2, radius, mPaint);
//        mPaint.setColor(Color.BLUE & 0x7fffffff);
//        canvas.drawCircle(x3, y3, radius, mPaint);

        // произвольные фигуры
//        int centerX = width / 2;
//        int centerY = height / 2;
//        int padding = 50;
//        int minSide = Math.min(width, height);
//        int contentSize = minSide - 2 * padding;
//
//        float segmentSize = contentSize / 3;
//
//        Path path = new Path();
//        path.moveTo(segmentSize, 0);
//        path.lineTo(2 * segmentSize, 0);
//        path.lineTo(2 * segmentSize, segmentSize);
//        path.lineTo(3 * segmentSize, segmentSize);
//        path.lineTo(3 * segmentSize, 3 * segmentSize);
//        path.lineTo(2 * segmentSize, 3 * segmentSize);
//        path.lineTo(2 * segmentSize, 2 * segmentSize);
//        path.lineTo(segmentSize, 2 * segmentSize);
//        path.lineTo(segmentSize, 3 * segmentSize);
//        path.lineTo(0, 3 * segmentSize);
//        path.lineTo(0, segmentSize);
//        path.lineTo(segmentSize, segmentSize);
//        path.lineTo(segmentSize, 0);
//
//        path.offset(centerX - 1.5f * segmentSize, centerY - 1.5f * segmentSize);
//
//        mPaint.setColor(Color.WHITE);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeWidth(20);
//
//        canvas.drawPath(path, mPaint);
//    }


    /*
        ТО ЧТО ВЫШЕ:
        Такая архитектура кода годится в случае, если мы рисуем один раз.
        А что если код рисования нужно выполнить несколько раз? Много раз в секунду?
        В таком случае код, вычисляющий координаты будет выполняться снова и снова,
        но результат будет один и тот же (потому что наша сцена статичная, а её размеры не меняются).

        Так в самом деле может происходить на Android – View могу перерисовываться
        до 60 раз в секунду (это частота обновления кадров в графической системе Android),
        и выполнять лишний код во время отрисовки не рекомендуется. Код из примеров
        выше можно изменить таким образом, что вспомогательный вычисления
        будут выполняться минимально необходимое число раз. Для этого нужно делать так:

            1, Код, вычисляющий координаты, результат работы которого зависит только от размера View
            следует выполнять не в методе onDraw, а в методе View.onSizeChanged
            (документация по onSizeChanged, который вызывается каждый раз, когда размер View меняется.
            Он обязательно будет вызван как минимум один раз перед тем, как будет вызван onDraw.

            2, Код, который вычисляет что-то постоянное, не зависящее ни от чего,
            можно выполнить в конструкторе. Например, инициализацию объекта Paint нужными параметрами.

            С таким подходом код последнего примера будет выглядеть так:
     */

    private final Paint paint = new Paint();
    private final Path path = new Path();

    public DemoDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int centerX = w / 2;
        int centerY = h / 2;
        int padding = 50;
        int minSide = Math.min(w, h);
        int contentSize = minSide - 2 * padding;

        float segmentSize = contentSize / 3f;

        path.reset();

        path.moveTo(segmentSize, 0);
        path.lineTo(2 * segmentSize, 0);
        path.lineTo(2 * segmentSize, segmentSize);
        path.lineTo(3 * segmentSize, segmentSize);
        path.lineTo(3 * segmentSize, 3 * segmentSize);
        path.lineTo(2 * segmentSize, 3 * segmentSize);
        path.lineTo(2 * segmentSize, 2 * segmentSize);
        path.lineTo(segmentSize, 2 * segmentSize);
        path.lineTo(segmentSize, 3 * segmentSize);
        path.lineTo(0, 3 * segmentSize);
        path.lineTo(0, segmentSize);
        path.lineTo(segmentSize, segmentSize);
        path.lineTo(segmentSize, 0);

        path.offset(centerX - 1.5f * segmentSize, centerY - 1.5f * segmentSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }
}
