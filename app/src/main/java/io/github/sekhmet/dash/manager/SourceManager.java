package io.github.sekhmet.dash.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

import static io.github.sekhmet.dashapi.DashService.ACTION_DASH_SOURCE;

public class SourceManager {
    private List<Source> mSources = new ArrayList<>();
    private Context mContext;

    public SourceManager(Context context) {
        mContext = context;
    }

    public void loadSources() {
        PackageManager packageManager = mContext.getPackageManager();
        List<ResolveInfo> resolveInfos = packageManager.queryIntentServices(new Intent(ACTION_DASH_SOURCE), 0);

        for (ResolveInfo resolveInfo :
                resolveInfos) {
            Source source = new Source();
            source.name = resolveInfo.loadLabel(packageManager).toString();
            source.icon = resolveInfo.loadIcon(packageManager);
            source.componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);

            if (resolveInfo.serviceInfo.descriptionRes != 0) {
                try {
                    Context serviceContext = mContext.createPackageContext(source.componentName.getPackageName(), 0);
                    source.description = serviceContext.getResources().getString(resolveInfo.serviceInfo.descriptionRes);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }

            mSources.add(source);
        }
    }

    public List<Source> getSources() {
        return mSources;
    }
}
