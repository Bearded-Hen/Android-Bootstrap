package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.utils.DimenUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * See <a href="http://getbootstrap.com/components/#badges>http://getbootstrap.com/components/#alerts</a>
 */
public class BootstrapAlert extends RelativeLayout {

    private ImageView closeButton;
    private TextView alertText;

    private BootstrapBrand bootstrapBrand;

    private String strongText;
    private String messageText;

    private float baselineFontSize;
    private float baselinePadding;

    private AlphaAnimation fadeInAnimation;
    private AlphaAnimation fadeOutAnimation;

    private boolean dismissible;
    private boolean hidden;

    private OnDismissListener onDismissListener;

    private static final AtomicInteger nextGeneratedId = new AtomicInteger(1);

    public BootstrapAlert(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapAlert(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapAlert(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapAlert);

        try {
            int typeOrdinal = a.getInt(R.styleable.BootstrapAlert_bootstrapBrand, -1);

            this.bootstrapBrand = DefaultBootstrapBrand.fromAttributeValue(typeOrdinal);

            strongText = a.getString(R.styleable.BootstrapAlert_strongText);
            messageText = a.getString(R.styleable.BootstrapAlert_messageText);
            dismissible = a.getBoolean(R.styleable.BootstrapAlert_dismissible, false);
            if (strongText == null) {
                strongText = "";
            }
            if (messageText == null) {
                messageText = "";
            }
        }
        finally {
            a.recycle();
        }

        baselineFontSize = DimenUtils.pixelsFromSpResource(getContext(),
                                                           R.dimen.bootstrap_button_default_font_size);
        baselinePadding = DimenUtils.pixelsFromDpResource(getContext(),
                                                          R.dimen.bootstrap_alert_paddings);

        updateBootstrapState();
    }

    private void updateBootstrapState() {
        alertText = new TextView(getContext());
        closeButton = new ImageView(getContext());
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            alertText.setId(generateViewUniqueId());
            closeButton.setId(generateViewUniqueId());
        }
        else {
            alertText.setId(View.generateViewId());
            closeButton.setId(View.generateViewId());
        }
        fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(300);
        fadeInAnimation.setInterpolator(new AccelerateInterpolator());
        fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(300);
        fadeOutAnimation.setInterpolator(new AccelerateInterpolator());

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {setVisibility(VISIBLE);}

            @Override
            public void onAnimationEnd(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(GONE);
                if (onDismissListener != null) { onDismissListener.onDismiss(); }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        LayoutParams textParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                                                   LayoutParams.WRAP_CONTENT);
        LayoutParams closeParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                    LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.LEFT_OF, closeButton.getId());
        closeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        alertText.setLayoutParams(textParams);
        alertText.setTextSize(baselineFontSize);
        alertText.setGravity(Gravity.LEFT);
        alertText.setTextColor(
                BootstrapDrawableFactory.bootstrapButtonText(getContext(), true, bootstrapBrand));
        alertText.setText(Html.fromHtml(String.format("<b>%s</b>%s", strongText,
                                                      (strongText.length() > 0 ?
                                                              "&nbsp;" + messageText :
                                                              messageText))));

        closeButton.setLayoutParams(closeParams);
        closeButton.setBackgroundDrawable(
                BootstrapDrawableFactory.bootstrapAlertCloseIcon(getContext(),
                                                                 (int) baselineFontSize,
                                                                 (int) baselineFontSize,
                                                                 DimenUtils.dpToPixels(6)));

        Drawable bg = BootstrapDrawableFactory.bootstrapAlert(getContext(), bootstrapBrand);

        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(bg);
        }
        else {
            setBackgroundDrawable(bg);
        }
        addView(alertText);
        if (dismissible) {
            addView(closeButton);
            ((View) closeButton.getParent()).post(new Runnable() {
                @Override
                public void run() {
                    Rect bounds = new Rect();
                    closeButton.getHitRect(bounds);
                    bounds.top -= DimenUtils.dpToPixels(6);
                    bounds.bottom += DimenUtils.dpToPixels(6);
                    bounds.left -= DimenUtils.dpToPixels(6);
                    bounds.right += DimenUtils.dpToPixels(6);
                    TouchDelegate touchDelegate = new TouchDelegate(bounds, closeButton);
                    if (View.class.isInstance(closeButton.getParent())) {
                        ((View) closeButton.getParent()).setTouchDelegate(touchDelegate);
                    }
                }
            });
            closeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hide();
                }
            });
        }

        int vert = (int) (baselinePadding * 1.5);
        int hori = (int) (baselinePadding * 1.5);
        setPadding(hori, vert, hori, vert);
    }

    public void hide() {
        hidden = true;
        startAnimation(fadeOutAnimation);
    }

    public void show() {
        hidden = false;
        startAnimation(fadeInAnimation);
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    private int generateViewUniqueId() {
        for (; ; ) {
            final int result = nextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) {
                newValue = 1; // Roll over to 1, not 0.
            }
            if (nextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    public interface OnDismissListener {
        void onDismiss();
    }
}
