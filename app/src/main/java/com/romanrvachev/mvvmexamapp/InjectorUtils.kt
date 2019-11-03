package com.romanrvachev.mvvmexamapp

import com.romanrvachev.mvvmexamapp.datas.OurDatabase
import com.romanrvachev.mvvmexamapp.datas.QuoteRepository
import com.romanrvachev.mvvmexamapp.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(OurDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }

}