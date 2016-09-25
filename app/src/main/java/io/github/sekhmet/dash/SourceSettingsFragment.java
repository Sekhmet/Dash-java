package io.github.sekhmet.dash;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

public class SourceSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(getActivity());
        setPreferenceScreen(screen);

        SwitchPreference switchPreference = new SwitchPreference(getActivity());
        switchPreference.setTitle(getString(R.string.pref_source_enable_title));
        switchPreference.setSummary(R.string.pref_source_enable_summary);
        switchPreference.setDefaultValue(true);
        screen.addItemFromInflater(switchPreference);

        String[] refreshRateKeys = {"1", "2", "3", "4", "5", "6", "7"};
        ListPreference listPreference = new ListPreference(getActivity());
        listPreference.setTitle(getString(R.string.pref_source_refresh_frequency_title));
        listPreference.setSummary(getString(R.string.pref_source_refresh_frequency_summary));
        listPreference.setEntries(R.array.pref_source_refresh_frequency_entries);
        listPreference.setEntryValues(refreshRateKeys);
        listPreference.setValueIndex(3);
        screen.addItemFromInflater(listPreference);
    }
}
