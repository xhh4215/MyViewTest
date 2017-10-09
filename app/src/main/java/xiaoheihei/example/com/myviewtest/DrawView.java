package xiaoheihei.example.com.myviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xhh on 2017/10/9.
 */

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
         * 方法 说明 drawRect 绘制矩形 drawCircle 绘制圆形 drawOval 绘制椭圆 drawPath 绘制任意多边形
         * drawLine 绘制直线 drawPoin 绘制点
         */
        //创建画笔
        Paint paint  = new Paint();
        paint.setColor(Color.RED);
        /**
         * drawText()绘制文本
         * param1 绘制的内容
         * param2，param3 绘制的区域
         * param4 绘制时候使用的画笔
         */
        canvas.drawText("画圆",10,20,paint);
        /**
         * drawCircle() 绘制圆
         * param1 绘制的x坐标
         * param2 绘制的y坐标
         * param3 绘制的圆的半径
         * param4 绘制使用的画笔
         */
        canvas.drawCircle(60,30,20,paint);
        paint.setAntiAlias(true);//设置是否去除锯齿
        canvas.drawCircle(120,20,20,paint);

        canvas.drawText("画线及弧线",10,60,paint);
        paint.setColor(Color.GREEN);
        /**
         * drawLine()绘制直线
         * param1 ，param2 确定线的起始点
         * param3 ，param4 确定线的结束点
         */
        canvas.drawLine(60,40,100,40,paint);
        canvas.drawLine(110,40,190,80,paint);

        paint.setStyle(Paint.Style.STROKE);
        RectF oval1 = new RectF(150,20,180,40);
        canvas.drawArc(oval1,180,180,false,paint);
        oval1.set(190, 20, 220, 40);
        canvas.drawArc(oval1, 180, 180, false, paint);//小弧形
        oval1.set(160, 30, 210, 60);
        canvas.drawArc(oval1, 0, 180, false, paint);//小弧形

        canvas.drawText("画矩形",10,80,paint);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);
        /**
         * drawRect()绘制矩形
         * param1 左
         * param2 上
         * param3 右
         * param4 下
         */
        canvas.drawRect(60,60,80,80,paint);
        canvas.drawRect(60,90,160,100,paint);

        canvas.drawText("画扇形和椭圆",10,120,paint);
        //设置渐变的颜色
        Shader mShader = new LinearGradient(0,0,100,100,new
         int[]{Color.RED,Color.BLUE,Color.CYAN,Color.YELLOW},null,Shader.TileMode.REPEAT);
        paint.setShader(mShader);
        /***
         * RectF是一个矩形
         *  param1 ，param2 表示的是左上角的坐标。
         *  param3 ，param4 表示的是右下角的坐标。
         *  矩形宽度 param1-param3；
         *  矩形高度 param2-param4；
         */
        RectF oval2 = new RectF(60,100,200,240);

        //绘制扇形
        canvas.drawArc(oval2,200,130,true,paint);
        oval2.set(210,100,250,130);
        /***
         *   绘制椭圆
         *   param1 椭圆的外接矩形
         *   param2 绘制使用的画笔
         */
        canvas.drawOval(oval2,paint);
        RectF oval4 = new RectF(300,300,500,800);
        canvas.drawOval(oval4,paint);
        canvas.drawText("画三角形",10,200,paint);
        Path path = new Path();
        path.moveTo(80,200);
        path.lineTo(120,250);
        path.lineTo(80,250);
        path.close();
        canvas.drawPath(path,paint);

        // 你可以绘制很多任意多边形，比如下面画六连形
        paint.reset();//重置
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);//设置空心
        Path path1=new Path();
        //moveTo设置路径的开始的点的坐标
        path1.moveTo(180, 200);
        //lineTo将当前点和开始点进行连接
        path1.lineTo(200, 200);
        path1.lineTo(210, 210);
        path1.lineTo(200, 220);
        path1.lineTo(180, 220);
        path1.lineTo(170, 210);
        path1.close();//封闭
        canvas.drawPath(path1, paint);
        //画圆角矩形
        paint.setStyle(Paint.Style.FILL);//充满
        paint.setColor(Color.LTGRAY);
        paint.setAntiAlias(true);// 设置画笔的锯齿效果
        canvas.drawText("画圆角矩形:", 10, 260, paint);
        RectF oval3 = new RectF(80, 260, 200, 300);// 设置个新的长方形
        //绘制圆角的矩形
        canvas.drawRoundRect(oval3, 20, 15, paint);//第二个参数是x半径，第三个参数是y半径

        //画贝塞尔曲线
        canvas.drawText("画贝塞尔曲线:", 10, 310, paint);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        Path path2=new Path();
        path2.moveTo(100, 320);//设置Path的起点
        path2.quadTo(150, 310, 170, 400); //设置贝塞尔曲线的控制点坐标和终点坐标
        canvas.drawPath(path2, paint);//画出贝塞尔曲线

        //画点
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("画点：", 10, 390, paint);
        canvas.drawPoint(60, 390, paint);//画一个点
        canvas.drawPoints(new float[]{60,400,65,400,70,400}, paint);//画多个点

        //画图片，就是贴图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 250,360, paint);
    }
}
