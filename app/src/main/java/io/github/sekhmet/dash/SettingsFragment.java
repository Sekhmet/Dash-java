package io.github.sekhmet.dash;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.widget.Toast;

import java.util.List;

import io.github.sekhmet.dash.manager.Source;
import io.github.sekhmet.dash.manager.SourceManager;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setPreferenceScreen(null);
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
        ClickableSwitchPreference preference = new ClickableSwitchPreference(getActivity());

        preference.setKey(source.componentName.getPackageName() + source.componentName.getClassName() + "dash_key_enabled");
        preference.setIcon(source.icon);
        preference.setTitle(source.name);
        preference.setSummary(source.description);
        getPreferenceScreen().addItemFromInflater(preference);
        
        preference.setSwitchClickListener(new ClickableSwitchPreference.SwitchClickListener() {
            @Override
            public void onSwitchClicked(boolean checked) {

            }

            @Override
            public void onPreferenceClicked() {
                Intent intent = new Intent(getActivity(), SourceSettingsActivity.class);
                intent.putExtra(getString(R.string.intent_extra_source), source);
                startActivity(intent);
            }
        });
    }

}
