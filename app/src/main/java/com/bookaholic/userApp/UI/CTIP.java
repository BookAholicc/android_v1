package com.bookaholic.userApp.UI;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

import com.bookaholic.userApp.utils.FontCache;

/**
 * Created by nandhu on 12/8/17.
 *
 */

public class CTIP extends TextInputEditText {
    public CTIP(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CTIP(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CTIP(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }
    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/whiteny_book_reg.ttf", context);
        setTypeface(customFont);
    }
}
