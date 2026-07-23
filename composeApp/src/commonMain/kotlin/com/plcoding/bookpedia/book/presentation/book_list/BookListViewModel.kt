package com.plcoding.bookpedia.book.presentation.book_list

import androidx.lifecycle.ViewModel
import com.plcoding.bookpedia.book.domain.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class BookListViewModel : ViewModel() {

    private val _state = MutableStateFlow(BookListState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                searchResults = (1..100).map {
                    Book(
                        id = it.toString(),
                        title = "Book $it",
                        imageUrl = "https://test.com",
                        authors = listOf("Author $it"),
                        description = "Description $it",
                        languages = listOf("en"),
                        firstPublishYear = "2024",
                        averageRating = 4.5,
                        ratingCount = 10,
                        numPages = 100,
                        numEditions = 3
                    )
                },
                favoritesBooks = (1..10).map {
                    Book(
                        id = (it + 100).toString(),
                        title = "Favorite Book $it",
                        imageUrl = "https://test.com",
                        authors = listOf("Author $it"),
                        description = "Description $it",
                        languages = listOf("en"),
                        firstPublishYear = "2024",
                        averageRating = 4.8,
                        ratingCount = 50,
                        numPages = 200,
                        numEditions = 1
                    )
                }
            )
        }
    }

    fun onAction(action: BookListAction) {
        when (action) {
            is BookListAction.OnSearchQueryChange -> {
                _state.update {
                    it.copy(searchQuery = action.query)
                }
            }
            is BookListAction.OnBookClick -> {
                // TODO: Handle book selection/navigation
            }
            is BookListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
     }
}