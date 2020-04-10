package io.dearzack.audioandvideo.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapUtils {

    public static Bitmap zoomBitmap(Bitmap srcBitmap, int newWidth, int newHeight) {
        // 获取这个图片的宽和高
        int width = srcBitmap.getWidth();
        int height = srcBitmap.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(srcBitmap, 0, 0, width, height, matrix, true);
    }
}
