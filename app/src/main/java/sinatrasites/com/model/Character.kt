package sinatrasites.com.model


import android.os.Parcelable
import android.widget.RatingBar
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character (
    var id : String,
    var name: String,
    var description: String,
    var ratingBar: Float,
    var type: String,
    var image : String,
    var coordinates : String,
    var temp: String,
    var location: String
): Parcelable