package io.github.sekhmet.dash;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import io.github.sekhmet.dash.manager.Source;

public class SourceSettingsFragment extends PreferenceFragment {

    private Source source;

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key = source.componentName.getPackageName() + source.componentName.getClassName();

        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());
        setPreferenceScreen(screen);

        SwitchPreference switchPreference = new SwitchPreference(getActivity());
        switchPreference.setKey(key + "dash_key_enabled");
        switchPreference.setTitle(getString(R.string.pref_source_enable_title));
        screen.addItemFromInflater(switchPreference);
    }
}
