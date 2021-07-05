package com.animation.codelock;


import android.util.AttributeSet;
import android.content.Context;
import androidx.appcompat.widget.AppCompatButton;


public class CodeLockButton extends AppCompatButton {

    public CodeLockButton(Context context) {
        super(context);
    }

    public CodeLockButton(Context context, AttributeSet attrs ) {
        super(context, attrs);
    }

    public CodeLockButton(Context context, AttributeSet attrs, int defaultStyleAttr ) {
        super(context, attrs, defaultStyleAttr);
    }


    /** Functions for an ObjectAnimator: scaling a button in X and Y directions **/
    public void setScaleXY(float scale) {
        this.setScaleX(scale);
        this.setScaleY(scale);
    }
    public float getScaleXY() {
        return this.getScaleX();
    }



}
