package id.co.gits.gitsplayground.view.recyclerviewpaging
import com.google.gson.annotations.SerializedName


data class StackOverflow(
    @SerializedName("has_more")
    val hasMore: Boolean?,
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("quota_max")
    val quotaMax: Int?,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int?
)

data class Item(
    @SerializedName("answer_id")
    val answerId: Int?,
    @SerializedName("creation_date")
    val creationDate: Int?,
    @SerializedName("is_accepted")
    val isAccepted: Boolean?,
    @SerializedName("last_activity_date")
    val lastActivityDate: Int?,
    @SerializedName("last_edit_date")
    val lastEditDate: Int?,
    @SerializedName("owner")
    val owner: Owner?,
    @SerializedName("question_id")
    val questionId: Int?,
    @SerializedName("score")
    val score: Int?
)

data class Owner(
    @SerializedName("display_name")
    val displayName: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("profile_image")
    val profileImage: String?,
    @SerializedName("reputation")
    val reputation: Int?,
    @SerializedName("user_id")
    val userId: Int?,
    @SerializedName("user_type")
    val userType: String?
)