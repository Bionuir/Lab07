package com.example.lab07

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insert(user: User)

    // Nueva consulta para obtener el último usuario añadido
    @Query("SELECT * FROM User ORDER BY uid DESC LIMIT 1")
    suspend fun getLastUser(): User?

    // Nueva función para eliminar un usuario
    @Query("DELETE FROM User WHERE uid = :uid")
    suspend fun deleteUserById(uid: Int)
}