package con.modhe.uncash.ui.main.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * author Created by harrishuang on 2020-09-21.
 * email : huangjinping1000@163.com
 */
public class LinearLayout2 extends LinearLayout {
    public LinearLayout2(Context context) {
        super(context);
    }

    public LinearLayout2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LinearLayout2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.d("okhttp", "====c==dispatchTouchEvent=" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("okhttp", "====c==onTouchEvent=" + event.getAction());

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("okhttp", "====c==onInterceptTouchEvent=" + ev.getAction());

        return super.onInterceptTouchEvent(ev);
    }
}
