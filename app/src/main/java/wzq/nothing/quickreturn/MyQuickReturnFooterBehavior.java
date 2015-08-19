package wzq.nothing.quickreturn;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * QuickReturnFooter View 的 Behavior
 * Created by wangziqiang on 2015/8/18.
 */
public class MyQuickReturnFooterBehavior extends CoordinatorLayout.Behavior<View> {

    String TAG = "MyQuickReturnFooterBehavior";
    private int mDySinceDirectionChanged;

    // 记得初始化构造函数
    public MyQuickReturnFooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View
            target, int nestedScrollAxes) {
        // 我们只关心竖直方向的滑动
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[]
            consumed) {
        // 1,向上滑动，隐藏底部的Footer
        // 2,向下滑动，展示底部的Footer

        // 如果变向了，则重置 mDySinceDirectionChanged，并且取消bottom footer的动画
        if ((dy > 0 && mDySinceDirectionChanged < 0) || dy < 0 && mDySinceDirectionChanged > 0) {
            mDySinceDirectionChanged = 0;
        }
        android.util.Log.e(TAG, "----------------------dy = " + dy);
        mDySinceDirectionChanged += dy;// dy > 0 代表上滑；dy < 0 代表下滑
        android.util.Log.e(TAG, "mDySinceDirectionChanged = " + mDySinceDirectionChanged);

        if (mDySinceDirectionChanged > child.getHeight()) {
            // hide bottom footer
            hideView(child);
        } else if (mDySinceDirectionChanged < -child.getHeight()) {
            // show bottom footer
            showView(child);
        }

        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
    }

    private static final FastOutSlowInInterpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    /**
     * 隐藏view
     *
     * @param view
     */
    private void hideView(final View view) {
        android.util.Log.e(TAG, "hideView()");
        ViewPropertyAnimator animator = view.animate()
                .translationY(view.getHeight())
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);
        animator.start();
    }

    /**
     * 显示view
     *
     * @param view
     */
    private void showView(final View view) {
        android.util.Log.e(TAG, "showView()");
        ViewPropertyAnimator animator = view.animate()
                .translationY(0)
                .setInterpolator(INTERPOLATOR)
                .setDuration(200);
        animator.start();
    }

}
