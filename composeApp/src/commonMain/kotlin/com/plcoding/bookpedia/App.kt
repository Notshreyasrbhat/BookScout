package com.plcoding.bookpedia

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.plcoding.bookpedia.book.presentation.book_list.BookListScreenRoot
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel

import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel() },
        onBookClick = {

        }
    )
}