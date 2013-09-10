package com.chqla.immediatememory.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SettingData implements Parcelable {
	public int colNumber = 3;
	public double time = 3;
	
	public SettingData() {
		
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(colNumber);
		dest.writeDouble(time);
	}
	
	// this is used to regenerate your object.
	// All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<SettingData> CREATOR = new Parcelable.Creator<SettingData>() {
        public SettingData createFromParcel(Parcel in) {
            return new SettingData(in);
        }
        public SettingData[] newArray(int size) {
            return new SettingData[size];
        }
    };

    private SettingData(Parcel in) {
        colNumber = in.readInt();
        time = in.readDouble();
    }
}
