package domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

public class City implements Parcelable {

    private String cityName;
    private @DrawableRes int icon;

    protected City(Parcel in) {
        cityName = in.readString();
        icon = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getCityName() {
        return cityName;
    }

    public int getIcon() {
        return icon;
    }

    public City(String cityName, int icon) {
        this.cityName = cityName;
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cityName);
        parcel.writeInt(icon);
    }
}
