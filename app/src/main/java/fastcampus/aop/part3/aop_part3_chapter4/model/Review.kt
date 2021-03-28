package fastcampus.aop.part3.aop_part3_chapter4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Review(
    @PrimaryKey val uid: Int?,
    @ColumnInfo(name = "review") val review: String?
)