package io.github.sekhmet.hackernewssource;

import android.content.Intent;

import io.github.sekhmet.dashapi.DashService;

public class HackerNewsService extends DashService {
    public static final String NAME = "HackerNewsService";

    public HackerNewsService() {
        super(NAME);
    }

    public HackerNewsService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
