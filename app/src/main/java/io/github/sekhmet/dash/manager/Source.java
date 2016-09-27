package io.github.sekhmet.dash.manager;

import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Source implements Parcelable {
    public static final Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
        }
    };
    public String name;
    public String description;
    public ComponentName componentName;
    public Drawable icon;

    public Source() {
    }

    protected Source(Parcel in) {
        name = in.readString();
        description = in.readString();
        componentName = in.readParcelable(ComponentName.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeParcelable(componentName, flags);
    }
}
