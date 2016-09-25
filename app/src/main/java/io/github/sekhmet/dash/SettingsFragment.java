package io.github.sekhmet.dash;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import java.util.List;

import io.github.sekhmet.dash.manager.Source;
import io.github.sekhmet.dash.manager.SourceManager;

public class SettingsFragment extends PreferenceFragment {

    OnSourceClickListener onSourceClickListener;

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

    public void createSourceCategory(Source source) {
        Preference preference = new Preference(getActivity());

        preference.setIcon(source.icon);
        preference.setTitle(source.name);
        preference.setSummary(source.description);
        getPreferenceScreen().addItemFromInflater(preference);

        final SourceSettingsFragment sourceSettingsFragment = new SourceSettingsFragment();

        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                onSourceClickListener.onSourceClick(sourceSettingsFragment);
                return true;
            }
        });
    }

    public void setOnSourceClickListener(OnSourceClickListener onSourceClickListener) {
        this.onSourceClickListener = onSourceClickListener;
    }

    public interface OnSourceClickListener {
        boolean onSourceClick(Fragment fragment);
    }
}
