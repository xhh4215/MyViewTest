package xiaoheihei.example.com.myviewtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xhh on 2017/10/9.
 */

public class BitmapShaper extends View {
    private BitmapShader bitmapShader = null;
    private Bitmap bitmap = null;
    private Paint paint = null;
    private ShapeDrawable shapeDrawable = null;
    private int bitmapwidth;
    private int bitmapheight;

    public BitmapShaper(Context context) {
        super(context);

    }

    public BitmapShaper(Context context, AttributeSet set) {
        super(context, set);
        bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.text)).getBitmap();
        bitmapheight = bitmap.getHeight();
        bitmapwidth = bitmap.getWidth();
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.REPEAT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setShader(bitmapShader);
        shapeDrawable.setBounds(0,0, bitmapwidth , bitmapheight);
        shapeDrawable.draw(canvas);

    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int width;
        int height;
        if (widthmode == MeasureSpec.EXACTLY) {
            width = widthsize;
        } else {
            width = getWidth();
        }
        if (heightmode == MeasureSpec.EXACTLY) {
            height = heightsize;
        } else {
            height = getHeight();
        }
        setMeasuredDimension(width,height);
    }
}
