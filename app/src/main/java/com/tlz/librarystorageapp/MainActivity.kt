package com.tlz.librarystorageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tlz.librarystorageapp.repository.Repository
import com.tlz.librarystorageapp.room.BookEntity
import com.tlz.librarystorageapp.room.BooksDB
import com.tlz.librarystorageapp.screens.UpdateScreen
import com.tlz.librarystorageapp.ui.theme.LibraryStorageAppTheme
import com.tlz.librarystorageapp.viewmodel.BookViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryStorageAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mContext = LocalContext.current
                    val db = BooksDB.getInstance(mContext)
                    val repo = Repository(db)
                    val myViewModel = BookViewModel(repository = repo)

                    // Nav
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable("MainScreen") {
                            MainScreen(viewModel = myViewModel, navController)
                        }
                        composable("UpdateScreen/{bookId}") {
                            UpdateScreen(viewModel = myViewModel, bookId = it.arguments?.getString("bookId"))
                        }
                        
                    }



                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: BookViewModel, navController: NavHostController) {

    var inputBook by remember {
        mutableStateOf("")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = inputBook,
            onValueChange = {
                            enteredText -> inputBook = enteredText
            },
            label = { Text(text = "Book Name") },
            placeholder = { Text(text = "Enter Book Name") }
        )

        Button(onClick = {
            viewModel.addBook(BookEntity(0, inputBook))

        }) {
            Text(text = "Insert Book into database")
        }

        BooksList(viewModel = viewModel, navController)
        
    }
}

@Composable
fun BookCard(viewModel: BookViewModel, book: BookEntity, navController: NavHostController) {

    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        
        Row {
            Text(text = "" + book.id, fontSize = 24.sp,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp))
            
            Text(text = book.title, fontSize = 24.sp)
            
            IconButton(onClick = { viewModel.deleteBook(book = book) }) {
                Icon(imageVector = Icons.Default.Delete,
                    contentDescription = "Delete")
            }


            IconButton(onClick = {
                navController.navigate("UpdateScreen/${book.id}")
            }) {
                Icon(imageVector = Icons.Default.Edit,
                    contentDescription = "Edit")
            }

        }
    }
}

@Composable
fun BooksList(viewModel: BookViewModel, navController: NavHostController) {

    val books by viewModel.books.collectAsState(initial = emptyList())

    LazyColumn() {
        items(items = books) {
                item -> BookCard(
            viewModel = viewModel,
            book = item,
            navController
        )
        }

    }
}