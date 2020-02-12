package br.com.ioasys.camp.playmoney.ui

import android.os.Bundle
import br.com.ioasys.camp.playmoney.R
import br.com.ioasys.camp.playmoney.MainActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
    }
    override fun onStart() {
        super.onStart()
        ButtonBackLogin.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ButtonNewPassword.setOnClickListener(){
            //TODO: pegar o dado do campo de e-mail e mandar para o back
            //TODO: criar um aviso para o usuário se o email foi enviado com sucesso ou não
            //Retorno para a tela de login
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}