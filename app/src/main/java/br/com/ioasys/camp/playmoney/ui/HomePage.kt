package br.com.ioasys.camp.playmoney.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.MainActivity
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

    override fun onStart() {
        super.onStart()
        ButtonFinalizeGame.setOnClickListener(){
            //Retorno para a tela de login
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
        ButtonIcHelp.setOnClickListener(){
            val intent = Intent(this, Teacher::class.java)
            startActivity(intent)
        }
    }

}