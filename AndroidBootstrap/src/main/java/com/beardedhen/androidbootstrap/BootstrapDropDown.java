package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.PopupWindowCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapBrand;
import com.beardedhen.androidbootstrap.api.attributes.ViewGroupPosition;
import com.beardedhen.androidbootstrap.api.defaults.DefaultBootstrapSize;
import com.beardedhen.androidbootstrap.api.defaults.ExpandDirection;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;
import com.beardedhen.androidbootstrap.api.view.OutlineableView;
import com.beardedhen.androidbootstrap.api.view.RoundableView;
import com.beardedhen.androidbootstrap.utils.ColorUtils;
import com.beardedhen.androidbootstrap.utils.DimenUtils;
import com.beardedhen.androidbootstrap.utils.DrawableUtils;
import com.beardedhen.androidbootstrap.utils.ViewUtils;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * BootstrapButtons are buttons which provide contextual menus, styled with BootstrapBrand colors,
 * roundable corners, and an 'outlineable' mode.
 */
@BetaApi
public class BootstrapDropDown extends AwesomeTextView implements View.OnClickListener, RoundableView, OutlineableView, PopupWindow.OnDismissListener {

    private static final String TAG = "com.beardedhen.androidbootstrap.BootstrapDropDown";
    private static final String KEY_DIRECTION = "com.beardedhen.androidbootstrap.BootstrapDropDown.EXPAND_DIRECTION";

    private static final String SEARCH_REGEX_HEADER = "\\{dropdown_header\\}.*";
    private static final String SEARCH_REGEX_SEPARATOR = "\\{dropdown_separator\\}.*";
    private static final String SEARCH_REGEX_DISABLED = "\\{dropdown_disabled\\}.*";
    private static final String REPLACE_REGEX_HEADER = "\\{dropdown_header\\}";
    private static final String REPLACE_REGEX_SEPARATOR = "\\{dropdown_separator\\}";
    private static final String REPLACE_REGEX_DISABLED = "\\{dropdown_disabled\\}";
    private static final int SCREEN_WIDTH_GUESS = 1000;

    private ExpandDirection expandDirection;
    private PopupWindow dropdownWindow;
    private View.OnClickListener clickListener;
    private String[] dropdownData;
    private OnDropDownItemClickListener onDropDownItemClickListener;

    private boolean roundedCorners;
    private boolean showOutline;

    private float bootstrapSize;
    private int itemHeight;
    private int dropDownViewHeight;
    private int dropDownViewWidth;
    private int screenWidth;

    private float baselineStrokeWidth;
    private float baselineCornerRadius;
    private float baselineFontSize;
    private float baselineDropDownViewFontSize;
    private float baselineItemRightPadding;
    private float baselineItemLeftPadding;
    private float baselineVertPadding;
    private float baselineHoriPadding;

    public BootstrapDropDown(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapDropDown(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapDropDown(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BootstrapDropDown);

        try {
            this.roundedCorners = a.getBoolean(R.styleable.BootstrapDropDown_roundedCorners, false);
            this.showOutline = a.getBoolean(R.styleable.BootstrapDropDown_showOutline, false);

            int directionOrdinal = a.getInt(R.styleable.BootstrapDropDown_bootstrapExpandDirection, -1);
            int dataOrdinal = a.getResourceId(R.styleable.BootstrapDropDown_dropdownResource, -1);
            int sizeOrdinal = a.getInt(R.styleable.BootstrapDropDown_bootstrapSize, -1);

            expandDirection = ExpandDirection.fromAttributeValue(directionOrdinal);

            bootstrapSize = DefaultBootstrapSize.fromAttributeValue(sizeOrdinal).scaleFactor();
            itemHeight = a.getDimensionPixelSize(R.styleable.BootstrapDropDown_itemHeight, (int) DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_dropdown_default_item_height));

            if (isInEditMode()) {
                dropdownData = new String[] {"Android Studio", "Layout Preview", "Is Always", "Breaking"};
            }
            else {
                dropdownData = getContext().getResources().getStringArray(dataOrdinal);
            }
        }
        finally {
            a.recycle();
        }

        baselineStrokeWidth = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_dropdown_default_edge_width);
        baselineCornerRadius = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_dropdown_default_corner_radius);
        baselineFontSize = DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_dropdown_default_font_size);
        baselineDropDownViewFontSize = DimenUtils.pixelsFromSpResource(getContext(), R.dimen.bootstrap_dropdown_default_item_font_size);
        baselineItemLeftPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_dropdown_default_item_left_padding);
        baselineItemRightPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_dropdown_default_item_right_padding);
        baselineVertPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_vert_padding);
        baselineHoriPadding = DimenUtils.pixelsFromDpResource(getContext(), R.dimen.bootstrap_button_default_hori_padding);

        if (isInEditMode()) {
            screenWidth = SCREEN_WIDTH_GUESS; // take a sensible guess
        }
        else {
            DisplayMetrics metrics = new DisplayMetrics();
            ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
            screenWidth = metrics.widthPixels;
        }

        createDropDown();
        updateDropDownState();
    }

    private void createDropDown() {
        ScrollView dropdownView = createDropDownView();
        dropdownWindow = new PopupWindow();
        dropdownWindow.setFocusable(true);
        dropdownWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        if (!isInEditMode()) {
            dropdownWindow.setBackgroundDrawable(DrawableUtils.resolveDrawable(android.R.drawable
                                                                                       .dialog_holo_light_frame, getContext()));
        }

        dropdownWindow.setContentView(dropdownView);
        dropdownWindow.setOnDismissListener(this);
        dropdownWindow.setAnimationStyle(android.R.style.Animation_Activity);
        float longestStringWidth = measureStringWidth(getLongestString(dropdownData))
                + DimenUtils.dpToPixels((baselineItemRightPadding + baselineItemLeftPadding) * bootstrapSize);

        if (longestStringWidth < getMeasuredWidth()) {
            dropdownWindow.setWidth(DimenUtils.dpToPixels(getMeasuredWidth()));
        }
        else {
            dropdownWindow.setWidth((int) longestStringWidth + DimenUtils.dpToPixels(8));
        }
    }

    private ScrollView createDropDownView() {
        final LinearLayout dropdownView = new LinearLayout(getContext());
        ScrollView scrollView = new ScrollView(getContext());
        int clickableChildCounter = 0;

        dropdownView.setOrientation(LinearLayout.VERTICAL);
        int height = (int) (itemHeight * bootstrapSize);
        LayoutParams childParams = new LayoutParams(LayoutParams.MATCH_PARENT, height);

        for (String text : dropdownData) {
            TextView childView = new TextView(getContext());
            childView.setGravity(Gravity.CENTER_VERTICAL);
            childView.setLayoutParams(childParams);

            int padding = (int) (baselineItemLeftPadding * bootstrapSize);
            childView.setPadding(padding, 0, padding, 0);
            childView.setTextSize(baselineDropDownViewFontSize * bootstrapSize);
            childView.setTextColor(ColorUtils.resolveColor(android.R.color.black, getContext()));

            Drawable background = getContext().obtainStyledAttributes(null, new int[]{
                    android.R.attr.selectableItemBackground}, 0, 0)
                                            .getDrawable(0);
            ViewUtils.setBackgroundDrawable(childView, background);

            childView.setTextColor(BootstrapDrawableFactory.bootstrapDropDownViewText(getContext()));
            childView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dropdownWindow.dismiss();
                    if (onDropDownItemClickListener != null) {
                        onDropDownItemClickListener.onItemClick(dropdownView, v, v.getId());
                    }
                }
            });

            if (Pattern.matches(SEARCH_REGEX_HEADER, text)) {
                childView.setText(text.replaceFirst(REPLACE_REGEX_HEADER, ""));
                childView.setTextSize((baselineDropDownViewFontSize - 2F) * bootstrapSize);
                childView.setClickable(false);
                childView.setTextColor(ColorUtils.resolveColor(R.color.bootstrap_gray_light,
                                                               getContext()));
            }
            else if (Pattern.matches(SEARCH_REGEX_SEPARATOR, text)) {
                childView = new DividerView(getContext());
                childView.setClickable(false);
                childView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 3));
            }
            else if (Pattern.matches(SEARCH_REGEX_DISABLED, text)) {
                childView.setEnabled(false);
                childView.setId(clickableChildCounter++);
                childView.setText(text.replaceFirst(REPLACE_REGEX_DISABLED, ""));
            }
            else {
                childView.setText(text);
                childView.setId(clickableChildCounter++);
            }
            dropdownView.addView(childView);
        }

        dropdownView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        dropDownViewHeight = dropdownView.getMeasuredHeight();
        dropDownViewWidth = dropdownView.getMeasuredWidth();

        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        scrollView.addView(dropdownView);

        cleanData();
        return scrollView;
    }

    private void updateDropDownState() {
        super.updateBootstrapState();

        BootstrapBrand bootstrapBrand = getBootstrapBrand();

        float cornerRadius = baselineCornerRadius;
        float strokeWidth = baselineStrokeWidth;
        final float fontSize = baselineFontSize * bootstrapSize;

        strokeWidth *= bootstrapSize;

        super.setOnClickListener(this);
        setTextSize(fontSize);
        setGravity(Gravity.CENTER);

        setCompoundDrawablesWithIntrinsicBounds(null, null,
                BootstrapDrawableFactory.bootstrapDropDownArrow(getContext(),
                        DimenUtils.dpToPixels(8 * bootstrapSize),
                        DimenUtils.dpToPixels(12 * bootstrapSize),
                        expandDirection,
                        showOutline,
                        getBootstrapBrand())
                , null);
        setCompoundDrawablePadding(DimenUtils.dpToPixels(8));

        setTextColor(BootstrapDrawableFactory.bootstrapButtonText(
                getContext(),
                showOutline,
                bootstrapBrand));

        Drawable bg = BootstrapDrawableFactory.bootstrapButton(getContext(),
                bootstrapBrand,
                (int) strokeWidth,
                (int) cornerRadius,
                ViewGroupPosition.SOLO,
                showOutline,
                roundedCorners);

        ViewUtils.setBackgroundDrawable(this, bg);

        int vert = (int) (baselineVertPadding * bootstrapSize);
        int hori = (int) (baselineHoriPadding * bootstrapSize);
        setPadding(hori, vert, hori, vert);
    }

    /**
     * Calculating string width
     *
     * @param text String to calculate
     * @return width of String in pixels
     */
    private float measureStringWidth(String text) {
        Paint mPaint = new Paint();
        mPaint.setTextSize(baselineDropDownViewFontSize * bootstrapSize);
        return (float) (DimenUtils.dpToPixels(mPaint.measureText(text)));
    }


    /**
     * Searching for longest string in array
     *
     * @param array input string array
     * @return longest string
     */
    private String getLongestString(String[] array) {
        int maxLength = 0;
        String longestString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }

    private void cleanData() {
        String[] cleanArray = new String[dropdownData.length];
        for (int i = 0; i < dropdownData.length; i++) {
            cleanArray[i] = dropdownData[i].replaceAll(REPLACE_REGEX_HEADER, "")
                    .replaceAll(REPLACE_REGEX_DISABLED, "")
                    .replaceAll(REPLACE_REGEX_SEPARATOR, "");
        }
        dropdownData = cleanArray;
    }

    /**
     * Sets a listener which will be called when an item is clicked in the dropdown.
     *
     * @param onDropDownItemClickListener the listener
     */
    public void setOnDropDownItemClickListener(OnDropDownItemClickListener onDropDownItemClickListener) {
        this.onDropDownItemClickListener = onDropDownItemClickListener;
    }

    @Override public boolean isShowOutline() {
        return showOutline;
    }

    @Override public boolean isRounded() {
        return roundedCorners;
    }

    /**
     * Gets the direction in which the dropdown expands.
     *
     * @return the direction
     */
    public ExpandDirection getExpandDirection() {
        return expandDirection;
    }

    /**
     * Retrieves the data used to populate the dropdown.
     *
     * @return a string array of values
     */
    public String[] getDropdownData() {
        return dropdownData;
    }

    @Override public void setShowOutline(boolean showOutline) {
        this.showOutline = showOutline;
        updateDropDownState();
    }

    @Override public void setRounded(boolean rounded) {
        this.roundedCorners = rounded;
        updateDropDownState();
    }

    /**
     * Sets the direction in which the dropdown should expand.
     *
     * @param expandDirection the direction
     */
    public void setExpandDirection(ExpandDirection expandDirection) {
        this.expandDirection = expandDirection;
        updateDropDownState();
    }

    /**
     * Sets the String values which should be used to populate the menu displayed in the dropdown.
     *
     * @param dropdownData an array of string values.
     */
    public void setDropdownData(String[] dropdownData) {
        this.dropdownData = dropdownData;
        createDropDown();
        updateDropDownState();
    }

    @Override public void onDismiss() {
        setSelected(false);
        dropdownWindow.getContentView().scrollTo(0, 0);
    }

    @Override public void onClick(View v) {
        if (clickListener != null) {
            clickListener.onClick(v);
        }
        //using 8dip on axisX offset to make dropdown view visually be at start of dropdown itself
        //using 4dip on axisY offset to make space between dropdown view and dropdown itself
        //all offsets are necessary because of the dialog_holo_light_frame to display correctly on screen(shadow was made by inset)
        int gravity;
        int axisXOffset;
        if (dropDownViewWidth + getX() > screenWidth) {
            gravity = Gravity.TOP | Gravity.END;
            axisXOffset = DimenUtils.dpToPixels(8);
        }
        else {
            gravity = Gravity.TOP | Gravity.START;
            axisXOffset = -DimenUtils.dpToPixels(8);
        }
        int axisYOffset = DimenUtils.dpToPixels(4);
        switch (expandDirection) {
            case UP:
                PopupWindowCompat.showAsDropDown(dropdownWindow, v,
                        axisXOffset,
                        -dropDownViewHeight - getMeasuredHeight() - axisYOffset * 3,
                        gravity);
                break;
            case DOWN:
                PopupWindowCompat.showAsDropDown(dropdownWindow, v,
                        axisXOffset,
                        -axisYOffset,
                        gravity);
                break;
        }
        setSelected(true);
    }

    @Override public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, super.onSaveInstanceState());

        bundle.putBoolean(RoundableView.KEY, roundedCorners);
        bundle.putBoolean(OutlineableView.KEY, showOutline);
        bundle.putSerializable(KEY_DIRECTION, expandDirection);
        bundle.putFloat(BootstrapSizeView.KEY, bootstrapSize);

        return bundle;
    }

    @Override public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;

            this.roundedCorners = bundle.getBoolean(RoundableView.KEY);
            this.showOutline = bundle.getBoolean(OutlineableView.KEY);
            this.bootstrapSize = bundle.getFloat(BootstrapSizeView.KEY);

            Serializable direction = bundle.getSerializable(KEY_DIRECTION);

            if (direction instanceof ExpandDirection) {
                expandDirection = (ExpandDirection) direction;
            }
        }
        super.onRestoreInstanceState(state);
    }

    @Override public void setOnClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    /**
     * A listener which provides methods relating to {@link BootstrapDropDown}
     */
    public interface OnDropDownItemClickListener {

        /**
         * Called when an item is clicked in a {@link BootstrapDropDown}
         *
         * @param parent the parent viewgroup
         * @param v      the view
         * @param id     the id
         */
        void onItemClick(ViewGroup parent, View v, int id);
    }

    private static class DividerView extends TextView {

        private final Paint paint;

        public DividerView(Context context) {
            super(context);
            paint = new Paint();
            paint.setColor(ColorUtils.resolveColor(R.color.bootstrap_dropdown_divider, context));
        }

        @Override protected void onDraw(Canvas canvas) {
            canvas.drawLine(0, 1, canvas.getWidth(), 1, paint);
            super.onDraw(canvas);
        }
    }
}
