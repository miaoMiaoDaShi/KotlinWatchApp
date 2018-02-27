package cn.zcoder.xxp.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/1/30
 * Description :
 */


public class SelectAddrsView extends View {

    /**
     * 画小圆点
     */
    private Paint mPointPaint;
    /**
     * 画圆圈 描边
     */
    private Paint mCircleStrokePaint;
    /**
     * 画文字
     */
    private Paint mTextPaint;
    /**
     * 画文字的蓝色背景
     */
    private Paint mTextBgPaint;
    /**
     * 填充圆
     */
    private Paint mCircleFillPaint;

    private float cx;
    private float cy;

    private float radius;
    private Paint mCenterPointPaint;
    private int mTextWidth;
    private int mTextHeight;
    private Bitmap mCenterBitmap;
    private Rect mBitmapRect;
    private String mText;
    private Rect mDrawCenterRect;
    private int mInterval;
    private float mDownX;
    private float mDownY;
    /**
     * 容错范围
     */
    private int mFaultTolerantScope;
    private int mTouchPoint;
    private String mTextFormat;
    private Point mPoint;

    public SelectAddrsView(Context context) {
        this(context, null);
    }

    public SelectAddrsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectAddrsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
        // setClickable(true);
    }


    private void setup() {
        initPaint();
        radius = getResources().getDimension(R.dimen.circle_radius);
        mTextWidth = (int) getResources().getDimension(R.dimen.text_bg_width);
        mTextHeight = (int) getResources().getDimension(R.dimen.text_bg_height);

        mCenterBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_select_current_location);
        mBitmapRect = new Rect(0, 0, mCenterBitmap.getWidth(), mCenterBitmap.getHeight());

        mTextFormat = "守护范围%.2f";
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        //文字和圆的间隔
        mInterval = (int) getResources().getDimension(R.dimen.interval);

        mFaultTolerantScope = (int) getResources().getDimension(R.dimen.fault_tolerant_scope);
    }


    /**
     * 画笔的初始化
     */
    private void initPaint() {
        mPointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPointPaint.setStrokeCap(Paint.Cap.ROUND);
        mPointPaint.setColor(getResources().getColor(R.color.warningColor));
        mPointPaint.setStrokeWidth(getResources().getDimension(R.dimen.point_size));


        mCircleStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleStrokePaint.setStyle(Paint.Style.STROKE);
        mCircleStrokePaint.setStrokeWidth(getResources().getDimension(R.dimen.circle_stroke_width));
        mCircleStrokePaint.setColor(Color.parseColor("#0195FF"));

        mCircleFillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCircleFillPaint.setStyle(Paint.Style.FILL);
        mCircleFillPaint.setColor(Color.parseColor("#500195FF"));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(getResources().getDimension(R.dimen.text_size));

        mTextBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextBgPaint.setColor(Color.parseColor("#0195FF"));

        mCenterPointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        cx = getWidth() / 2;
        cy = getHeight() / 2;
        mDrawCenterRect = new Rect((int) (cx - mCenterBitmap.getWidth() / 2), (int) (cy - mCenterBitmap.getHeight() / 2),
                (int) (cx + mCenterBitmap.getWidth() / 2), (int) (cy + mCenterBitmap.getHeight() / 2));
        //左上右下的点的坐标
        final Point leftPoint = new Point((int) (cx - radius), (int) cy);
        final Point topPoint = new Point((int) cx, (int) (cy - radius));
        final Point rightPoint = new Point((int) (cx + radius), (int) cy);
        final Point bottomPoint = new Point((int) cx, (int) (cy + radius));


        final RectF textBgRect = new RectF(
                cx - mTextWidth / 2, cy - radius - mTextHeight - mInterval,
                cx + mTextWidth / 2, cy - radius - mInterval);


        //画圆  描边
        canvas.drawCircle(cx, cy, radius, mCircleStrokePaint);
        //画圆 填充
        canvas.drawCircle(cx, cy, radius, mCircleFillPaint);


        //画中间的小圆点
        canvas.drawBitmap(mCenterBitmap, mBitmapRect, mDrawCenterRect, mCenterPointPaint);

        //依次画左上右下的小红点
        canvas.drawPoints(new float[]{
                leftPoint.x, leftPoint.y,
                topPoint.x, topPoint.y,
                rightPoint.x, rightPoint.y,
                bottomPoint.x, bottomPoint.y}, mPointPaint);

        //画文字背景
        canvas.drawRoundRect(textBgRect, mTextHeight / 2, mTextHeight / 2, mTextBgPaint);

        //画文字
        Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
        int baseline = (int) ((textBgRect.bottom + textBgRect.top - fontMetrics.bottom - fontMetrics.top) / 2);

        float scope = 0;
        mPoint = new Point((int) cx, (int) cy);
        if (onZoomListener != null) {
            scope = onZoomListener.getScope(mPoint, radius);
        }
        mText = scope > 10000 ? String.format(mTextFormat, scope / 1000) + "千米" : String.format(mTextFormat, scope) + "米";
        canvas.drawText(mText, textBgRect.centerX(), baseline, mTextPaint);

    }


    public Point getCenterPoint() {
        return mPoint;
    }

    private static final String TAG = "SelectAddrsView";

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                mTouchPoint = judgeTouchScope(mDownX, mDownY);
                switch (mTouchPoint) {
                    case LEFT_POINT:
                    case TOP_POINT:
                    case RIGHT_POINT:
                    case BOTTOM_POINT:
                        return true;
                    default: {
                        return super.onTouchEvent(event);
                    }
                }
            case MotionEvent.ACTION_MOVE:
                float newRadius = 0;
                switch (mTouchPoint) {
                    case LEFT_POINT:
                        newRadius = cx - event.getX();
                        Log.i(TAG, "onTouchEvent: " + radius);
                        break;
                    case TOP_POINT:
                        newRadius = cy - event.getY();
                        break;
                    case RIGHT_POINT:
                        newRadius = event.getX() - cx;
                        break;
                    case BOTTOM_POINT:
                        newRadius = event.getY() - cy;
                        break;
                    default: {
                        return super.onTouchEvent(event);
                    }
                }
                if (newRadius > getWidth() / 2 || newRadius < getWidth() / 10) {
                    return true;
                }
                radius = newRadius;
                invalidate();
                break;
            default:
        }

        return true;

    }


    /**
     * 设置中心点
     */
    public void setCenterPoint(float cx, float cy) {
        radius = getResources().getDimension(R.dimen.circle_radius);
        this.cx = cx;
        this.cy = cy;
        invalidate();
    }

    public static final int LEFT_POINT = 0x11;
    public static final int TOP_POINT = 0x12;
    public static final int RIGHT_POINT = 0x13;
    public static final int BOTTOM_POINT = 0x14;


    /**
     * 判断按下的范围(主要处理左上右下四个点)
     *
     * @param downX
     * @param downY
     */
    private int judgeTouchScope(float downX, float downY) {
        final Point leftPoint = new Point((int) (cx - radius), (int) cy);
        final Point topPoint = new Point((int) cx, (int) (cy - radius));
        final Point rightPoint = new Point((int) (cx + radius), (int) cy);
        final Point bottomPoint = new Point((int) cx, (int) (cy + radius));

        if (Math.abs(downX - leftPoint.x) < mFaultTolerantScope && Math.abs(downY - leftPoint.y) < mFaultTolerantScope) {
            return LEFT_POINT;
        } else if (Math.abs(downX - topPoint.x) < mFaultTolerantScope && Math.abs(downY - topPoint.y) < mFaultTolerantScope) {
            return TOP_POINT;
        } else if (Math.abs(downX - rightPoint.x) < mFaultTolerantScope && Math.abs(downY - rightPoint.y) < mFaultTolerantScope) {
            return RIGHT_POINT;
        } else if (Math.abs(downX - bottomPoint.x) < mFaultTolerantScope && Math.abs(downY - bottomPoint.y) < mFaultTolerantScope) {
            return BOTTOM_POINT;
        }

        return -1;
    }

    private OnZoomListener onZoomListener;

    public void setOnZoomListener(SelectAddrsView.OnZoomListener onZoomListener) {
        this.onZoomListener = onZoomListener;
    }

    public interface OnZoomListener {
        float getScope(Point centerPoint, float radius);

    }
}
