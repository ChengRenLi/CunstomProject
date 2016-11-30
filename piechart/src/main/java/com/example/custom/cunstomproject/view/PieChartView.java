package com.example.custom.cunstomproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * 画一个饼状图
 */

public class PieChartView extends View {
    //初始化画笔
    private Paint paint = new Paint();
    //设置颜色集合
    private int[] colors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080, 0xFFE6B800, 0xFF7CFC00};

    int height;
    int width;

    float[] pecent;

    //画笔相关设置
    private void initPaint(){
        paint.setColor(Color.RED);  //设置画笔颜色
        paint.setStrokeWidth(10);   //设置画笔宽度
        paint.setStyle(Paint.Style.FILL);//设置画笔的模式
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint(); //在初始化view的是初始化画笔
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //获取view宽高
        this.width = w;
        this.height = h;
    }
    //暴露方法，让外部将数据传入
    public void setPecent(float ... pecent){
        this.pecent = pecent;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //计算圆心以及半径
        int result = height > width ? width / 2 : height / 2;
        //画弧度所要用到的矩形
        RectF rectF = new RectF(0, 0, 2 * result, 2 * result);
        //画圆
        canvas.drawCircle(result,result,result,paint);
        float large = 0;
        if (pecent == null || pecent.length == 0)
            return;;
        for (int i = 0; i < pecent.length; i++){
            //恢复画笔
            paint.reset();
            paint.setColor(colors[getColor(i)]);
            canvas.drawArc(rectF, large , large + pecent[i], true, paint);
            large = large + pecent[i];


        }


    }
    //取颜色
    private int getColor(int i){
        int index = 0;
       if (i < colors.length-1){
           index = i;
       }else{
           index =  getColor(i - colors.length);
       }
        return index;
    }
}
