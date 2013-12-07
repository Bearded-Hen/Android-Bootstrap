package com.beardedhen.androidbootstrap.typography;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.utils.FontUtils;

import com.beardedhen.androidbootstrap.R;


public class Heading extends TextView
{
    //private static int[] styleable = R.styleable.BootstrapTypography;
    //private static int defStyle = R.style.BootstrapTypographyHeading;
    //private static int attributeName = R.attr.BootstrapHeadingStyle;

    public Heading(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    public Heading(Context context, AttributeSet attrs)
    {
        this(context, attrs, R.attr.bootstrapHeadingStyle);
    }

    public Heading(Context context)
    {
        this(context, null);
    }

    private void init(Context context, AttributeSet attrs, int defStyle)
    {
        Log.v("init", "starting");
        //used in Designer view
        if (isInEditMode()) {
            return;
        }

        //get font
        //readFont(getContext());


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BootstrapTypography, defStyle, R.style.BootstrapTypographyHeading);
        Log.v("typeqq", "setting typeface");

        try {
            if(a.getString(R.styleable.BootstrapTypography_bt_test) != null)
            {
                boolean test = a.getBoolean(R.styleable.BootstrapTypography_bt_test, false);
            }
        }
        finally {
            a.recycle();
        }

        Typeface face = FontUtils.getFont(context, "roboto-black");
        if(face != null)
        {
            this.setTypeface(face);
        }



    }
}
