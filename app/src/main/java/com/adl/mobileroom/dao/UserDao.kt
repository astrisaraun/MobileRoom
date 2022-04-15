package com.adl.mobileroom.dao

import androidx.room.*
import com.adl.mobileroom.model.UserModel

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: UserModel)
    @Update
    fun updateUser(user: UserModel)
    @Delete
    fun deleteUser(user: UserModel)
    @Query("SELECT * FROM UserModel")
    fun getAll(): List<UserModel>
}