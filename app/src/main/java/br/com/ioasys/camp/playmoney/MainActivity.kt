package br.com.ioasys.camp.playmoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ioasys.camp.playmoney.ui.CreateAccount
import br.com.ioasys.camp.playmoney.ui.ForgotPassword
import br.com.ioasys.camp.playmoney.ui.HomePage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onStart(){
        super.onStart()
        ButtonForgotPassword.setOnClickListener{
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }

        ButtonCreateAccount.setOnClickListener(){
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }

        ButtonLogin.setOnClickListener(){
            val intent = Intent (this, HomePage::class.java)
            startActivity(intent)
        }

    }
}
