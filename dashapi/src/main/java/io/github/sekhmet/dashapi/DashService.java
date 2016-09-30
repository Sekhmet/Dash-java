package io.github.sekhmet.dashapi;

import android.app.IntentService;
import android.content.Intent;

public class DashService extends IntentService {
    public static final String ACTION_DASH_SOURCE =
            "io.github.sekhmet.dashapi.DashService";


    public DashService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
    }
}
