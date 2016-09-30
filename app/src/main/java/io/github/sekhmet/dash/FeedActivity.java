package io.github.sekhmet.dash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.DimenHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class FeedActivity extends AppCompatActivity {

    Drawer drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        PrimaryDrawerItem feedItem = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withIcon(R.drawable.ic_dashboard_black_24dp)
                .withName(R.string.menu_dashboard);

        PrimaryDrawerItem settingsItem = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withIcon(R.drawable.ic_settings_black_24dp)
                .withName(R.string.menu_settings);

        DimenHolder holder = new DimenHolder();
        holder.setDp(160);

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHeader(R.layout.layout_drawer_header)
                .withHeaderHeight(holder)
                .addDrawerItems(
                        feedItem,
                        new DividerDrawerItem(),
                        settingsItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch ((int) drawerItem.getIdentifier()) {
                            case 2:
                                return openSettings();
                            default:
                                return false;
                        }
                    }
                })
                .build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawer.setSelection(1);
    }

    private boolean openSettings() {
        drawer.closeDrawer();
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        return true;
    }
}
