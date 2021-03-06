package cn.meiauto.matwidget.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author : LiYang
 * email  : yang.li@nx-engine.com
 * time   : 2018/2/6
 */
public class ClickableImageView extends AppCompatImageView {

    private static final int SELECT_COLOR = 0x33555555;

    public ClickableImageView(Context context) {
        this(context, null);
    }

    public ClickableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClickableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setClickable(true);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isClickable() && isEnabled()) {
            handleEvent(event);
        }
        return super.onTouchEvent(event);
    }

    public void handleEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setColorFilter(SELECT_COLOR, PorterDuff.Mode.SRC_ATOP);
                break;
            case MotionEvent.ACTION_UP:
                clearColorFilter();
                break;
            case MotionEvent.ACTION_CANCEL:
                clearColorFilter();
                break;
        }
    }
}
