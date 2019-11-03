package com.romanrvachev.mvvmexamapp.datas

data class Quotes (
    var text: String,
    var author: String
){
    override fun toString(): String {
        return "$text - $author"
    }
}