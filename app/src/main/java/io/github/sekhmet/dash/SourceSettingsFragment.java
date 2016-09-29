package io.github.sekhmet.dash;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.widget.Toast;

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
        switchPreference.setDefaultValue(true);
        screen.addItemFromInflater(switchPreference);

        String[] refreshRateKeys = {"1", "2", "3", "4", "5", "6", "7"};
        ListPreference listPreference = new ListPreference(getActivity());
        listPreference.setKey(key + "dash_key_refresh_rate");
        listPreference.setTitle(getString(R.string.pref_source_refresh_frequency_title));
        listPreference.setSummary(getString(R.string.pref_source_refresh_frequency_summary));
        listPreference.setEntries(R.array.pref_source_refresh_frequency_entries);
        listPreference.setEntryValues(refreshRateKeys);
        listPreference.setDefaultValue("2");
        screen.addItemFromInflater(listPreference);
    }
}
