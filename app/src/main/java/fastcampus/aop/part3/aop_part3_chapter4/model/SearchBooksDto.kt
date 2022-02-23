package fastcampus.aop.part3.aop_part3_chapter4.model

import com.google.gson.annotations.SerializedName

data class SearchBooksDto(
    @SerializedName("items") val books: List<Book>
)