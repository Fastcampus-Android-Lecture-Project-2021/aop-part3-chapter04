package fastcampus.aop.part3.aop_part3_chapter4.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    @SerializedName("isbn") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("price") val priceSales: String,
    @SerializedName("image") val coverSmallUrl: String,
    @SerializedName("link") val mobileLink: String
): Parcelable