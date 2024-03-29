package sample.qiitaclient.model

import android.os.Parcel
import android.os.Parcelable

data class User(val id: String, val name: String, val profileImageUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = parcel.run {
        writeString(id)
        writeString(name)
        writeString(profileImageUrl)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User = parcel.run {
            User(parcel)
        }

        override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
    }
}
