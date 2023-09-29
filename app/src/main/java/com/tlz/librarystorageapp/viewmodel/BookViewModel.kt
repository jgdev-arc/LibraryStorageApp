package com.tlz.librarystorageapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tlz.librarystorageapp.repository.Repository
import com.tlz.librarystorageapp.room.BookEntity
import kotlinx.coroutines.launch

class BookViewModel(val repository: Repository): ViewModel() {

    fun addBook(book: BookEntity) {
        viewModelScope.launch {
            repository.addBookToRoom(book)
        }
    }

    val books = repository.getAllBooks()

    fun deleteBook(book: BookEntity) {
        viewModelScope.launch {
            repository.deleteBookFromRoom(book)
        }
    }

    fun updateBook(book: BookEntity) {
        viewModelScope.launch {
            repository.updateBook(book)
        }
    }

}