package app.oneecom.core.network.responses

import app.oneecom.core.R
import app.oneecom.core.constants.CoreStringResConstants
import app.oneecom.core.extentions.getString
import com.squareup.moshi.Json

//"id": 1006,
//"name": "Kurta set 6",
//"short_desc": "Women Printed Kurta Set 6",
//"base_price": 2500.0,
//"discount_price": 1250.0,
//"discount_percentage": 50.0,
//"image_url": "https://c.pxhere.com/photos/60/c8/adolescent_casual_contemporary_cute_elegant_fashion_formal_friendly-1173448.jpg!d",
//"category_id": "1001"
data class Product(
    val id: Long,
    val name: String,
    @Json(name = "short_desc")
    val shortDesc: String,
    @Json(name = "base_price")
    val basePrice: Double,
    @Json(name = "discount_price")
    val discountPrice: Double?,
    @Json(name = "discount_percentage")
    val discountPercentage: Double?,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "category_id")
    val categoryId: Long
) {
    fun formattedBasePrice(): String =
        getString(CoreStringResConstants.ID_UTF_RUPPEE) + basePrice.toInt().toString()

    fun formattedDiscountPrice(): String? =
        discountPrice?.let {
            getString(CoreStringResConstants.ID_UTF_RUPPEE) + it.toInt().toString()
        }

    fun formattedDiscountPercentage(): String? = discountPercentage?.let {
        "${it.toInt()}% ${getString(R.string.off)}"
    }
}