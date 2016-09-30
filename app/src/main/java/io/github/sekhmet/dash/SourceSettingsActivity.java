package io.github.sekhmet.dash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.github.sekhmet.dash.manager.Source;

public class SourceSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Source source = getIntent().getParcelableExtra(getString(R.string.intent_extra_source));

        if (source != null) {
            setTitle(source.name);

            SourceSettingsFragment fragment = new SourceSettingsFragment();

            fragment.setSource(source);

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.source_settings_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
