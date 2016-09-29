package io.github.sekhmet.dash;

import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

public class ClickableSwitchPreference extends SwitchPreference {
    public ClickableSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ClickableSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickableSwitchPreference(Context context) {
        super(context);
    }

    interface SwitchClickListener {
        public void onSwitchClicked(boolean checked);

        public void onPreferenceClicked();
    }

    private SwitchClickListener listener = null;

    public void setSwitchClickListener(SwitchClickListener listener) {
        this.listener = listener;
    }

    private Switch findSwitchWidget(View view) {
        if (view instanceof Switch) {
            return (Switch) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                if (child instanceof ViewGroup) {
                    Switch result = findSwitchWidget(child);
                    if (result != null) return result;
                }
                if (child instanceof Switch) {
                    return (Switch) child;
                }
            }
        }
        return null;
    }

    protected void onBindView(View view) {
        super.onBindView(view);

        final Switch switchView = findSwitchWidget(view);
        if (switchView != null) {
            switchView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) listener.onSwitchClicked(switchView.isChecked());
                }
            });
            switchView.setFocusable(true);
            switchView.setEnabled(true);
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onPreferenceClicked();
            }
        });

    }
}
