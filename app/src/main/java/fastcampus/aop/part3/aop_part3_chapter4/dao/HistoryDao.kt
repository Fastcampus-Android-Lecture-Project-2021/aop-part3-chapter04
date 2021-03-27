package fastcampus.aop.part3.aop_part3_chapter4.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fastcampus.aop.part3.aop_part3_chapter4.model.History

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history WHERE keyword = :keyword")
    fun delete(keyword: String)

}