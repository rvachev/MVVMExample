package com.romanrvachev.mvvmexamapp.datas

class OurDatabase private constructor(){

    var quoteDao = QuoteDao()
        private set

    companion object{
        @Volatile private var instance: OurDatabase? = null

        fun getInstance() = instance ?: synchronized(this){
            instance
                ?: OurDatabase().also { instance = it }
        }
    }

}