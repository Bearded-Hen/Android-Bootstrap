package com.beardedhen.androidbootstrap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.beardedhen.androidbootstrap.api.attributes.BootstrapSize;
import com.beardedhen.androidbootstrap.api.view.BootstrapSizeView;

import static com.beardedhen.androidbootstrap.BootstrapButton.Position.BOTTOM;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.END;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_HORI;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.MIDDLE_VERT;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.SOLO;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.START;
import static com.beardedhen.androidbootstrap.BootstrapButton.Position.TOP;

public class BootstrapButtonGroup extends LinearLayout implements BootstrapSizeView {

    private BootstrapSize bootstrapSize;

    public BootstrapButtonGroup(Context context) {
        super(context);
        initialise(null);
    }

    public BootstrapButtonGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialise(attrs);
    }

    public BootstrapButtonGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(attrs);
    }

    private void initialise(AttributeSet attrs) {
        refreshDrawState();
    }

    @Override public void setOrientation(int orientation) {
        super.setOrientation(orientation);
        refreshDrawState();
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        refreshDrawState();
    }

    private void refreshDrawState() {
        int childCount = getChildCount();
        int orientation = getOrientation();

        if (childCount == 0) {
            return;
        }
        else if (childCount == 1) {
            BootstrapButton button = retrieveButtonChild(0);
            button.setPosition(SOLO);
        }

        for (int i = 0; i < childCount; i++) {
            BootstrapButton button = retrieveButtonChild(i);

            if (i == 0) { // first view
                button.setPosition(orientation == HORIZONTAL ? START : TOP);
            }
            else if (i == childCount -1) { // last view
                button.setPosition(orientation == HORIZONTAL ? END : BOTTOM);
            }
            else {
                button.setPosition(orientation == HORIZONTAL ? MIDDLE_HORI : MIDDLE_VERT);
            }
        }
    }

    private BootstrapButton retrieveButtonChild(int i) {
        View view = getChildAt(i);

        if ((view instanceof BootstrapButton)) {
            return (BootstrapButton) view;
        }
        else {
            throw new IllegalStateException("All child view of BootstrapButtonGroup must be BootstrapButtons");
        }
    }

    @Override public void setBootstrapSize(BootstrapSize bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
    }

    @Override public BootstrapSize getBootstrapSize() {
        return bootstrapSize;
    }

}
