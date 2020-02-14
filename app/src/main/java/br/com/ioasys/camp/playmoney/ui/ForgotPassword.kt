package br.com.ioasys.camp.playmoney.ui

import android.os.Bundle
import br.com.ioasys.camp.playmoney.R
import br.com.ioasys.camp.playmoney.MainActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.RetrofitInitializer
import br.com.ioasys.camp.playmoney.UserForgotPassword
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            try {
                if (EmailForgotPassword.text.toString().equals("")) {
                    throw Exception("Favor preencher o campo de e-mail!")
                } else {
                    val call = RetrofitInitializer().userService()
                        .forgotPassword(UserForgotPassword(EmailForgotPassword.text.toString()))

                    call.enqueue(object : Callback<UserForgotPassword> {
                        override fun onResponse(
                            call: Call<UserForgotPassword>,
                            response: Response<UserForgotPassword>
                        ) {
                            //println("Resposta OK!")

                            if (response.body()?.email == null) {
                                Toast.makeText(
                                    this@ForgotPassword,
                                    "E-mail não encontrado",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                Toast.makeText(
                                    this@ForgotPassword,
                                    "E-mail de recuperação de senha enviado para o email cadastrado!",
                                    Toast.LENGTH_LONG
                                ).show()

                                //Retorno para a tela de login
                                val intent = Intent(this@ForgotPassword, MainActivity::class.java)
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<UserForgotPassword>, t: Throwable) {
                            //println("Sem resposta!!!")
                            Toast.makeText(
                                this@ForgotPassword,
                                "Falha ao enviar email de recuperação de senha!",
                                Toast.LENGTH_LONG
                            ).show()
                            Log.e("ERRO ", t?.message)
                        }
                    })
                }
            }
            catch (e: Exception)
            {
                Toast.makeText(this@ForgotPassword, e.message.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
