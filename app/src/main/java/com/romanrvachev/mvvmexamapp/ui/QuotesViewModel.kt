package com.romanrvachev.mvvmexamapp.ui

import androidx.lifecycle.ViewModel
import com.romanrvachev.mvvmexamapp.datas.QuoteRepository
import com.romanrvachev.mvvmexamapp.datas.Quotes

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuotes(quotes: Quotes) = quoteRepository.addQuote(quotes)

}