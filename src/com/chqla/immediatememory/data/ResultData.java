package com.chqla.immediatememory.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ResultData implements Parcelable {
	public String statement;
	
	public ResultData(String s) {
		statement = s;
	}
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(statement);
	}
	
	// this is used to regenerate your object.
	// All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<ResultData> CREATOR = new Parcelable.Creator<ResultData>() {
        public ResultData createFromParcel(Parcel in) {
            return new ResultData(in);
        }
        public ResultData[] newArray(int size) {
            return new ResultData[size];
        }
    };

    private ResultData(Parcel in) {
        statement = in.readString();
    }
}
