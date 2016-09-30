package io.github.sekhmet.feedlysource;

import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import io.github.sekhmet.dashapi.DashService;

public class FeedlyService extends DashService {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
