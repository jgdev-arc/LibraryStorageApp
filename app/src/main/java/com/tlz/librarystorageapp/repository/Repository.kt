package com.tlz.librarystorageapp.repository

import com.tlz.librarystorageapp.room.BookEntity
import com.tlz.librarystorageapp.room.BooksDB

class Repository(val booksDB: BooksDB) {

    suspend fun addBookToRoom(bookEntity: BookEntity) {
        booksDB.bookDao().addBook(bookEntity)
    }


}