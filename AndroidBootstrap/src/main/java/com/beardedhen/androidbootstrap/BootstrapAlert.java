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
import com.beardedhen.androidbootstrap.utils.ViewUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * See
 * <a href="http://getbootstrap.com/components/#badges">http://getbootstrap.com/components/#alerts</a>
 */
@BetaApi
public class BootstrapAlert extends RelativeLayout implements Animation.AnimationListener {

    /**
     * Provides methods which receive callbacks in response to changes in the view visibility.
     */
    public interface VisibilityChangeListener{

        /**
         * Called when the alert is set to be dismissed with an animation.
         * @param alert the alert
         */
        void onAlertDismissStarted(BootstrapAlert alert);

        /**
         * Called when the alert is no longer visible.
         * @param alert the alert
         */
        void onAlertDismissCompletion(BootstrapAlert alert);

        /**
         * Called when the alert set to appear with an animation
         * @param alert the alert
         */
        void onAlertAppearStarted(BootstrapAlert alert);

        /**
         * Called when the alert is now visible.
         * @param alert the alert
         */
        void onAlertAppearCompletion(BootstrapAlert alert);
    }

    private ImageView closeButton;

    private BootstrapBrand bootstrapBrand;

    private String strongText;
    private String messageText;

    private float baselineFontSize;
    private float baselinePadding;

    private AlphaAnimation fadeInAnimation;
    private AlphaAnimation fadeOutAnimation;

    private boolean userDismissible;

    private VisibilityChangeListener visibilityChangeListener;

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
            userDismissible = a.getBoolean(R.styleable.BootstrapAlert_dismissible, false);

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
        setupAnimations();
        updateBootstrapState();
    }

    private void updateBootstrapState() {
        TextView alertText = new TextView(getContext());
        closeButton = new ImageView(getContext());

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            alertText.setId(generateViewUniqueId());
            closeButton.setId(generateViewUniqueId());
        }
        else {
            alertText.setId(View.generateViewId());
            closeButton.setId(View.generateViewId());
        }


        LayoutParams textParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                                                   LayoutParams.WRAP_CONTENT);
        LayoutParams closeParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                                                    LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.LEFT_OF, closeButton.getId());
        closeParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        alertText.setLayoutParams(textParams);
        alertText.setTextSize(baselineFontSize);
        alertText.setGravity(Gravity.START);
        alertText.setTextColor(
                BootstrapDrawableFactory.bootstrapButtonText(getContext(), true, bootstrapBrand));
        alertText.setText(Html.fromHtml(String.format("<b>%s</b>%s", strongText,
                                                      (strongText.length() > 0 ?
                                                              "&nbsp;" + messageText :
                                                              messageText))));

        closeButton.setLayoutParams(closeParams);
        Drawable buttonBg = BootstrapDrawableFactory.bootstrapAlertCloseIcon(
                getContext(), (int) baselineFontSize, (int) baselineFontSize,
                DimenUtils.dpToPixels(6));

        ViewUtils.setBackgroundDrawable(closeButton, buttonBg);

        Drawable bg = BootstrapDrawableFactory.bootstrapAlert(getContext(), bootstrapBrand);
        ViewUtils.setBackgroundDrawable(this, bg);

        addView(alertText);

        if (userDismissible) {
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
                    dismiss(true);
                }
            });
        }

        int vert = (int) (baselinePadding * 1.5);
        int hori = (int) (baselinePadding * 1.5);
        setPadding(hori, vert, hori, vert);
    }

    private void setupAnimations() {
        fadeInAnimation = new AlphaAnimation(0.0f, 1.0f);
        fadeInAnimation.setDuration(300);
        fadeInAnimation.setInterpolator(new AccelerateInterpolator());
        fadeInAnimation.setAnimationListener(this);

        fadeOutAnimation = new AlphaAnimation(1.0f, 0.0f);
        fadeOutAnimation.setDuration(300);
        fadeOutAnimation.setInterpolator(new AccelerateInterpolator());
        fadeOutAnimation.setAnimationListener(this);
    }

    /**
     * Hides the alert with an animation, setting its visibility to {@link View#GONE}
     * @param  animated whether the dismissal should be animated or not
     */
    public void dismiss(boolean animated) {
        if (animated) {
            if (visibilityChangeListener != null) {
                visibilityChangeListener.onAlertDismissStarted(this);
            }
            startAnimation(fadeOutAnimation);
        }
        else {
            setVisibility(GONE);
        }
    }

    /**
     * Shows the alert with an animation, setting its visibility to {@link View#VISIBLE}
     * @param  animated whether the appearance should be animated or not
     */
    public void show(boolean animated) {
        if (animated) {
            if (visibilityChangeListener != null) {
                visibilityChangeListener.onAlertAppearStarted(this);
            }
            startAnimation(fadeInAnimation);
        }
        else {
            setVisibility(VISIBLE);
        }
    }

    /**
     * Retrieves whether the user can dismiss the dialog or not
     * @return true if dismissable
     */
    public boolean isUserDismissible() {
        return userDismissible;
    }

    /**
     * Sets whether the user can dismiss the dialog or not.
     * @param userDismissible true if dismissable
     */
    public void setUserDismissible(boolean userDismissible) {
        this.userDismissible = userDismissible;
        updateBootstrapState();
    }

    /**
     * Sets a {@link VisibilityChangeListener} that will be notified on changes
     *
     * @param visibilityChangeListener the listener
     */
    public void setVisibilityChangeListener(VisibilityChangeListener visibilityChangeListener) {
        this.visibilityChangeListener = visibilityChangeListener;
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

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);

        if (visibilityChangeListener != null) {
            if (GONE == visibility) {
                visibilityChangeListener.onAlertDismissCompletion(this);
            }
            else if (VISIBLE == visibility) {
                visibilityChangeListener.onAlertAppearCompletion(this);
            }
        }
    }

    // Animation change listener

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (animation == fadeInAnimation) {
            setVisibility(VISIBLE);
        }
        else if (animation == fadeOutAnimation) {
            setVisibility(GONE);
        }
        else {
            throw new IllegalStateException("Unsupported animation attempted to use this listener");
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
