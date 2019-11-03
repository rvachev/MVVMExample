package com.romanrvachev.mvvmexamapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.romanrvachev.mvvmexamapp.InjectorUtils
import com.romanrvachev.mvvmexamapp.R
import com.romanrvachev.mvvmexamapp.datas.Quotes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            quotes_container.text = stringBuilder.toString()
        })

        confirm_button.setOnClickListener {
            val quote = Quotes(text_input.text.toString(), author_input.text.toString())
            viewModel.addQuotes(quote)
            text_input.setText("")
            author_input.setText("")
        }
    }
}
