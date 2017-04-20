package com.dimanych.guardiannews.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.reginald.swiperefresh.CustomSwipeRefreshLayout;

import static com.reginald.swiperefresh.CustomSwipeRefreshLayout.State.STATE_COMPLETE;
import static com.reginald.swiperefresh.CustomSwipeRefreshLayout.State.STATE_NORMAL;

/**
 * <p></p>
 *
 * @author Dmitriy Grigoriev
 */
public class ProgressBarView extends ProgressBar
        implements CustomSwipeRefreshLayout.CustomSwipeRefreshHeadLayout
{

    public ProgressBarView(Context context) {
        super(context);
    }

    public ProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onStateChange(CustomSwipeRefreshLayout.State currentState,
                              CustomSwipeRefreshLayout.State lastState)
    {
        switch (currentState.getRefreshState()) {
            case STATE_NORMAL:
                setVisibility(VISIBLE);
                break;
            case STATE_COMPLETE:
                setVisibility(GONE);
                break;

        }
    }
}
