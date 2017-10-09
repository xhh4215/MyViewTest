package xiaoheihei.example.com.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xhh on 2017/10/9.
 */

public class LinearGradientView extends View {
    private LinearGradient linearGradient = null;
    private Paint paint;
    public LinearGradientView(Context context) {
        super(context);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        linearGradient = new LinearGradient(0,0,100,100,
//                new int[]{Color.YELLOW,Color.BLUE,Color.TRANSPARENT,Color.WHITE},null, Shader.TileMode.REPEAT);
          //只在y轴的方向进行颜色的渐变
          linearGradient = new LinearGradient(0,0,300,0,Color.RED,Color.GREEN,Shader.TileMode.CLAMP);
         paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShader(linearGradient);
        canvas.drawCircle(240,360,200,paint);
    }
}
