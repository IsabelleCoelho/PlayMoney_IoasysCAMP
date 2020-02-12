package br.com.ioasys.camp.playmoney.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.R
import kotlinx.android.synthetic.main.activity_create_password.*

class CreatePassword : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)

    }

    override fun onStart(){
        super.onStart()
        ButtonBackCreateAccount.setOnClickListener(){
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }

}