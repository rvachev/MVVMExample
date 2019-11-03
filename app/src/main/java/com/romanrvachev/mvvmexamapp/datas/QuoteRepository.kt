package com.romanrvachev.mvvmexamapp.datas

class QuoteRepository private constructor(private val quoteDao: QuoteDao) {

    fun addQuote(quotes: Quotes){
        quoteDao.addQuote(quotes)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object{
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: QuoteDao) = instance ?: synchronized(this){
            instance
                ?: QuoteRepository(quoteDao).also { instance = it }
        }
    }

}