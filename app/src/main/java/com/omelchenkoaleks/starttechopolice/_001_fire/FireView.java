package com.omelchenkoaleks.starttechopolice._001_fire;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import java.util.Random;

public class FireView extends View {

    /*
        ХОТЯ КОД НИЖЕ ПО ЛОГИКЕ ПРАВИЛЬНЫЙ - В ЧЕМ ПРОБЛЕМА?
        На самом деле, в логике кода нет ошибки. Проблема в том, что мы используем
        неподходящие для нашей задачи методы. Мы рисуем пиксели в цикле при помощи метода Canvas.drawPoint.
        Количество пикселей зависит от экрана устройстов, но можно приблизительно
        считать его равным одному миллиону. А вот метод Canvas.drawPoint,
        как и вызов любого другого метода Canvas.drawSomething при рисовании на экране,
        устроен так, что в момент вызова ничего фактические не рисуется,
        а формируется Open GL команда на отрисовку. Потом, после того, как onDraw отработал,
        все команды для отрисовки одного кадра собираются вместе и отправляются в графический процессор,
        где они фактически выполняются. Отрисовать за раз миллион пикселей
        для современного Android устройства не проблема,
        а вот выполнить миллион команд на отрисовку одного пикслеля – это непосильная задача.

        ПОЭТОМУ НИКТО НЕ РИСУЕТ ПИСКСЕЛИ ПРИ ПОМОЩИ Canvas.drawPoint !!!
     */

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        for (int x = 0; x < fireWidth; x ++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//    }
//
//    private void drawFire(Canvas canvas) {
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                paint.setColor(color);
//
//                canvas.drawPoint(x, y, paint);
//            }
//        }
//    }


    /*
        ОСНОВА ДВИЖКА:
     */

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    // Bitmap
//    // Сначала установим значения всех пикселей в битмапе
//    // Потом нарисуем этот битмап при помощи метода Canvas.drawBitmap
//
//    private Bitmap bitmap;
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);
//
//        for (int x = 0; x < fireWidth; x++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//    }
//
//
//    private void drawFire(Canvas canvas) {
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                bitmap.setPixel(x, y, color);
//            }
//        }
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//    }



    // РАСПРОСТРАНЕНИЕ ОГНЯ - добавлен алгоритм

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//    private Bitmap bitmap;
//    private final Random random = new Random();
//
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);
//
//        for (int x = 0; x < fireWidth; x++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//        spreadFire();
//    }
//
//
//    private void drawFire(Canvas canvas) {
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                bitmap.setPixel(x, y, color);
//            }
//        }
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//    }
//
//    private void spreadFire() {
//        for (int y = 0; y < fireHeight - 1; y++) {
//            for (int x = 0; x < fireWidth; x++) {
//                int rand_x = random.nextInt(3);
//                int rand_y = random.nextInt(6);
//                int dst_x = Math.min(fireWidth - 1, Math.max(0, x + rand_x - 1));
//                int dst_y = Math.min(fireHeight - 1, y + rand_y);
//                int deltaFire = -(rand_x & 1);
//                firePixels[x][y] = Math.max(0, firePixels[dst_x][dst_y] + deltaFire);
//            }
//        }
//    }




    // ОБНОВЛЕНИЕ КАДРОВ - теперь нам нужно сделать так, чтобы Android перерисовывал FireView
    // снова и снова в бесконечном цикле – тогда мы увидим последовательность смены кадров с горящим огнем.

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//    private Bitmap bitmap;
//    private final Random random = new Random();
//
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);
//
//        for (int x = 0; x < fireWidth; x++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//        spreadFire();
//        invalidate(); // ВОТ ПРОСТО ДОБАВЛЯЕМ ЭТОТ МЕТОД
//    }
//
//
//    private void drawFire(Canvas canvas) {
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                bitmap.setPixel(x, y, color);
//            }
//        }
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//    }
//
//    private void spreadFire() {
//        for (int y = 0; y < fireHeight - 1; y++) {
//            for (int x = 0; x < fireWidth; x++) {
//                int rand_x = random.nextInt(3);
//                int rand_y = random.nextInt(6);
//                int dst_x = Math.min(fireWidth - 1, Math.max(0, x + rand_x - 1));
//                int dst_y = Math.min(fireHeight - 1, y + rand_y);
//                int deltaFire = -(rand_x & 1);
//                firePixels[x][y] = Math.max(0, firePixels[dst_x][dst_y] + deltaFire);
//            }
//        }
//    }




    /*
        ВСЕ ЧТО ВЫШЕ РАБОТАЕТ ОЧЕНЬ МЕДЛЕНО - НУЖНЫ ОПТИМИЗАЦИИ
        убираем лишние вызовы из цикла:
     */

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//    private Bitmap bitmap;
//    private final Random random = new Random();
//
//    private int[] bitmapPixels;
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);
//
//        for (int x = 0; x < fireWidth; x++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//        spreadFire();
//        invalidate(); // ВОТ ПРОСТО ДОБАВЛЯЕМ ЭТОТ МЕТОД
//    }
//
//
//    private void drawFire(Canvas canvas) {
//        final int pixelCount = fireWidth * fireHeight;
//        if (bitmapPixels == null || bitmapPixels.length < pixelCount ) {
//            bitmapPixels = new int[pixelCount];
//        }
//
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                bitmapPixels[fireWidth * y + x] = color;
//            }
//        }
//        bitmap.setPixels(bitmapPixels, 0, fireWidth, 0, 0, fireWidth, fireHeight);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//    }
//
//    private void spreadFire() {
//        for (int y = 0; y < fireHeight - 1; y++) {
//            for (int x = 0; x < fireWidth; x++) {
//                int rand_x = random.nextInt(3);
//                int rand_y = random.nextInt(6);
//                int dst_x = Math.min(fireWidth - 1, Math.max(0, x + rand_x - 1));
//                int dst_y = Math.min(fireHeight - 1, y + rand_y);
//                int deltaFire = -(rand_x & 1);
//                firePixels[x][y] = Math.max(0, firePixels[dst_x][dst_y] + deltaFire);
//            }
//        }
//    }


    // ОПТИМИЗАЦИЯ 2 - меньше пикселей будет быстрее

//    private static final int[] firePalette = {
//            0xff070707,
//            0xff1F0707,
//            0xff2F0F07,
//            0xff470F07,
//            0xff571707,
//            0xff671F07,
//            0xff771F07,
//            0xff8F2707,
//            0xff9F2F07,
//            0xffAF3F07,
//            0xffBF4707,
//            0xffC74707,
//            0xffDF4F07,
//            0xffDF5707,
//            0xffDF5707,
//            0xffD75F07,
//            0xffD75F07,
//            0xffD7670F,
//            0xffCF6F0F,
//            0xffCF770F,
//            0xffCF7F0F,
//            0xffCF8717,
//            0xffC78717,
//            0xffC78F17,
//            0xffC7971F,
//            0xffBF9F1F,
//            0xffBF9F1F,
//            0xffBFA727,
//            0xffBFA727,
//            0xffBFAF2F,
//            0xffB7AF2F,
//            0xffB7B72F,
//            0xffB7B737,
//            0xffCFCF6F,
//            0xffDFDF9F,
//            0xffEFEFC7,
//            0xffFFFFFF
//    };
//
//    private final Paint paint = new Paint();
//    private Bitmap bitmap;
//    private final Random random = new Random();
//
//    private int[] bitmapPixels;
//    private int[][] firePixels;
//    private int fireWidth;
//    private int fireHeight;
//
//    public FireView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        fireWidth = w;
//        fireHeight = h;
//        firePixels = new int[fireWidth][fireHeight];
//
//        float aspectRatio = (float) w / h;
//        fireWidth = 150;
//        fireHeight = (int) (fireWidth / aspectRatio);
//
//
//        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);
//
//        for (int x = 0; x < fireWidth; x++) {
//            firePixels[x][fireHeight - 1] = firePalette.length - 1;
//        }
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        drawFire(canvas);
//        spreadFire();
//        invalidate(); // ВОТ ПРОСТО ДОБАВЛЯЕМ ЭТОТ МЕТОД
//    }
//
//
//    private void drawFire(Canvas canvas) {
//        final int pixelCount = fireWidth * fireHeight;
//        if (bitmapPixels == null || bitmapPixels.length < pixelCount ) {
//            bitmapPixels = new int[pixelCount];
//        }
//
//        for (int x = 0; x < fireWidth; x++) {
//            for (int y = 0; y < fireHeight; y++) {
//                int temperature = firePixels[x][y];
//                if (temperature < 0) {
//                    temperature = 0;
//                }
//                if (temperature >= firePalette.length) {
//                    temperature = firePalette.length - 1;
//                }
//                @ColorInt int color = firePalette[temperature];
//                bitmapPixels[fireWidth * y + x] = color;
//            }
//        }
//        bitmap.setPixels(bitmapPixels, 0, fireWidth, 0, 0, fireWidth, fireHeight);
//        canvas.drawBitmap(bitmap, 0, 0, paint);
//    }
//
//    private void spreadFire() {
//        for (int y = 0; y < fireHeight - 1; y++) {
//            for (int x = 0; x < fireWidth; x++) {
//                int rand_x = random.nextInt(3);
//                int rand_y = random.nextInt(6);
//                int dst_x = Math.min(fireWidth - 1, Math.max(0, x + rand_x - 1));
//                int dst_y = Math.min(fireHeight - 1, y + rand_y);
//                int deltaFire = -(rand_x & 1);
//                firePixels[x][y] = Math.max(0, firePixels[dst_x][dst_y] + deltaFire);
//            }
//        }
//    }




    // растягиваем на весь экран

    private static final int[] firePalette = {
            0xff070707,
            0xff1F0707,
            0xff2F0F07,
            0xff470F07,
            0xff571707,
            0xff671F07,
            0xff771F07,
            0xff8F2707,
            0xff9F2F07,
            0xffAF3F07,
            0xffBF4707,
            0xffC74707,
            0xffDF4F07,
            0xffDF5707,
            0xffDF5707,
            0xffD75F07,
            0xffD75F07,
            0xffD7670F,
            0xffCF6F0F,
            0xffCF770F,
            0xffCF7F0F,
            0xffCF8717,
            0xffC78717,
            0xffC78F17,
            0xffC7971F,
            0xffBF9F1F,
            0xffBF9F1F,
            0xffBFA727,
            0xffBFA727,
            0xffBFAF2F,
            0xffB7AF2F,
            0xffB7B72F,
            0xffB7B737,
            0xffCFCF6F,
            0xffDFDF9F,
            0xffEFEFC7,
            0xffFFFFFF
    };

    private final Paint paint = new Paint();
    private Bitmap bitmap;
    private final Random random = new Random();

    private int[] bitmapPixels;
    private int[][] firePixels;
    private int fireWidth;
    private int fireHeight;

    public FireView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        fireWidth = w;
        fireHeight = h;
        firePixels = new int[fireWidth][fireHeight];

        float aspectRatio = (float) w / h;
        fireWidth = 150;
        fireHeight = (int) (fireWidth / aspectRatio);


        bitmap = Bitmap.createBitmap(fireWidth, fireHeight, Bitmap.Config.RGB_565);

        for (int x = 0; x < fireWidth; x++) {
            firePixels[x][fireHeight - 1] = firePalette.length - 1;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawFire(canvas);
        spreadFire();
        invalidate(); // ВОТ ПРОСТО ДОБАВЛЯЕМ ЭТОТ МЕТОД
    }


    private void drawFire(Canvas canvas) {
        final int pixelCount = fireWidth * fireHeight;
        if (bitmapPixels == null || bitmapPixels.length < pixelCount ) {
            bitmapPixels = new int[pixelCount];
        }

        for (int x = 0; x < fireWidth; x++) {
            for (int y = 0; y < fireHeight; y++) {
                int temperature = firePixels[x][y];
                if (temperature < 0) {
                    temperature = 0;
                }
                if (temperature >= firePalette.length) {
                    temperature = firePalette.length - 1;
                }
                @ColorInt int color = firePalette[temperature];
                bitmapPixels[fireWidth * y + x] = color;
            }
        }
        bitmap.setPixels(bitmapPixels, 0, fireWidth, 0, 0, fireWidth, fireHeight);
        float scale = (float) getWidth() / fireWidth;
        canvas.scale(scale, scale);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    private void spreadFire() {
        for (int y = 0; y < fireHeight - 1; y++) {
            for (int x = 0; x < fireWidth; x++) {
                int rand_x = random.nextInt(3);
                int rand_y = random.nextInt(6);
                int dst_x = Math.min(fireWidth - 1, Math.max(0, x + rand_x - 1));
                int dst_y = Math.min(fireHeight - 1, y + rand_y);
                int deltaFire = -(rand_x & 1);
                firePixels[x][y] = Math.max(0, firePixels[dst_x][dst_y] + deltaFire);
            }
        }
    }

}
