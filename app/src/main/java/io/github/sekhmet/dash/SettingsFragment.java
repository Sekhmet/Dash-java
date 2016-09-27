package io.github.sekhmet.dash;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import java.util.List;

import io.github.sekhmet.dash.manager.Source;
import io.github.sekhmet.dash.manager.SourceManager;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        SourceManager sourceManager = new SourceManager(getActivity());
        sourceManager.loadSources();

        List<Source> sources = sourceManager.getSources();

        for (Source source :
                sources) {
            createSourceCategory(source);
        }
    }

    public void createSourceCategory(final Source source) {
        Preference preference = new Preference(getActivity());

        preference.setIcon(source.icon);
        preference.setTitle(source.name);
        preference.setSummary(source.description);
        getPreferenceScreen().addItemFromInflater(preference);

        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(getActivity(), SourceSettingsActivity.class);
                intent.putExtra(getString(R.string.intent_extra_source), source);
                startActivity(intent);
                return false;
            }
        });
    }

}
