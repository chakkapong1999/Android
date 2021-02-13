package com.tni.max.materialmeresource;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Data model for each row of the RecyclerView
 */
class Sport implements Parcelable {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private String detail;
    private final int imageResource;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     */
    Sport(String title, String info, String detail, int imageResource) {
        this.title = title;
        this.info = info;
        this.detail = detail;
        this.imageResource = imageResource;
    }

    protected Sport(Parcel in) {
        title = in.readString();
        info = in.readString();
        detail = in.readString();
        imageResource = in.readInt();
    }

    public static final Creator<Sport> CREATOR = new Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**
     * Gets the info about the sport.
     *
     * @return the info and detail about the sport.
     */
    String getInfo() {
        return info;
    }
    String getDetail() {
        return detail;
    }

    public int getImageResource() {
        return imageResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(info);
        dest.writeString(detail);
        dest.writeInt(imageResource);
    }
}
