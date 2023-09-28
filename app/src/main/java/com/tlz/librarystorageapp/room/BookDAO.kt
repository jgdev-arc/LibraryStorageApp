package com.tlz.librarystorageapp.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BookDAO {

    @Insert
    suspend fun addBook(bookEntity: BookEntity)



}
