package io.dearzack.audioandvideo.task001;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import io.dearzack.audioandvideo.R;
import io.dearzack.audioandvideo.util.BitmapUtils;

/**
 * 在 Android 平台绘制一张图片，使用至少 3 种不同的 API，ImageView，SurfaceView，自定义 View
 */
public class Task001DrawPictureActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private static final String TAG = "Task001DrawPicture";

    private SurfaceView surfaceView;
    private Task001DrawPicView task001DrawPicView;

    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Bitmap bitmap;
    private DrawRunnable drawRunnable;
    private Thread drawThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task001_draw_picture);
        surfaceView = findViewById(R.id.task001_sv);
        task001DrawPicView = findViewById(R.id.task001_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        paint = new Paint();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawRunnable = new DrawRunnable();
        drawThread = new Thread(drawRunnable);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.i(TAG, "width:" + width  + " height:" + height);
        bitmap = BitmapUtils.zoomBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.task001_pic), width, height);
        drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.interrupt();
    }

    private class DrawRunnable implements Runnable {
        @Override
        public void run() {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    canvas.drawBitmap(bitmap, 0, 0, paint);
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
