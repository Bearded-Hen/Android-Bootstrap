package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapBrand;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapBadgeView;
import com.beardedhen.androidbootstrap.api.view.BootstrapBrandView;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.utils.DimenUtils;
import com.beardedhen.androidbootstrap.utils.ViewUtils;

/**
 * See
 *
 * <a href="http://getbootstrap.com/components/#badges">http://getbootstrap.com/components/#badges</a>
 */
@BetaApi
public class BootstrapBadge extends ImageView implements BootstrapSizeView, BootstrapBrandView,
                                                         BootstrapBadgeView {

    private String badgeText;
    private int size;
    private boolean insideContainer;
    private BootstrapBrand bootstrapBrand = DefaultBootstrapBrand.REGULAR;
    private float bootstrapSize;
    private Drawable badgeDrawable;

    public BootstrapBadge(Context context) {
        super(context);
        init(null);
    }

    public BootstrapBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public BootstrapBadge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapBadge);

        try {
            int sizeOrdinal = a.getInt(R.styleable.BootstrapBadge_bootstrapSize, -1);

            if (badgeText == null) {
                badgeText = a.getString(R.styleable.BootstrapBadge_badgeText);
            }

            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal)
                                                .scaleFactor();
        }
        finally {
            a.recycle();
        }

        size = (int) DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_badge_default_size);
        updateBootstrapState();
    }

    private void updateBootstrapState() {
        badgeDrawable = BootstrapDrawableFactory.createBadgeDrawable(getContext(), bootstrapBrand,
                                                                     (int) (size * bootstrapSize),
                                                                     (int) (size * bootstrapSize),
                                                                     badgeText,
                                                                     insideContainer);

        ViewUtils.setBackgroundDrawable(this, badgeDrawable);
    }

    Drawable getBadgeDrawable() {
        return badgeDrawable;
    }

    @Override public String getBadgeText() {
        return badgeText;
    }

    @Override public void setBadgeText(String badgeText) {
        this.badgeText = badgeText;
        updateBootstrapState();
    }

    public void setBootstrapBrand(BootstrapBrand bootstrapBrand, boolean insideContainer) {
        this.insideContainer = insideContainer;
        setBootstrapBrand(bootstrapBrand);
    }

    @Override
    public void setBootstrapBrand(@NonNull BootstrapBrand bootstrapBrand) {
        this.bootstrapBrand = bootstrapBrand;
        updateBootstrapState();
    }

    @NonNull
    @Override
    public BootstrapBrand getBootstrapBrand() {
        return bootstrapBrand;
    }

    @Override
    public void setBootstrapSize(DefaultBootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize.scaleFactor();
        updateBootstrapState();
    }

    @Override
    public void setBootstrapSize(float bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
        updateBootstrapState();
    }

    @Override
    public float getBootstrapSize() {
        return bootstrapSize;
    }
}