package io.github.sekhmet.dashapi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class DashService extends Service {
    public static final String ACTION_DASH_SOURCE =
            "io.github.sekhmet.dashapi.DashService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
