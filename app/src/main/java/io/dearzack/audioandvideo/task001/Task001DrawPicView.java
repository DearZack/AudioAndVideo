package io.dearzack.audioandvideo.task001;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import io.dearzack.audioandvideo.R;
import io.dearzack.audioandvideo.util.BitmapUtils;

public class Task001DrawPicView extends View {
    private static final String TAG = "Task001DrawPicView";
    private Bitmap bitmap;
    private Paint paint;

    public Task001DrawPicView(Context context) {
        this(context, null);
    }

    public Task001DrawPicView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Task001DrawPicView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            //onDraw 调用时 onWindowFocusChanged可能还没走到
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.i(TAG, "width:" + getWidth() + " height:" + getHeight());
        bitmap = BitmapUtils.zoomBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.task001_pic), getWidth(), getHeight());
        //立刻刷新
        invalidate();
    }
}
