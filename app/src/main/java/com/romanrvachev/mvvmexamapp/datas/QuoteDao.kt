package com.romanrvachev.mvvmexamapp.datas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteDao {
    private val quoteList = mutableListOf<Quotes>()
    private val quotes = MutableLiveData<List<Quotes>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quotes){
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quotes>>
}