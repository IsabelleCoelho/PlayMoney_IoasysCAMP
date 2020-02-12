package br.com.ioasys.camp.playmoney.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.R
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage  :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        setSupportActionBar(mToolbar)
        val actionBar = supportActionBar
        actionBar?.title = " "
    }

}