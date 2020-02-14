package br.com.ioasys.camp.playmoney

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.ioasys.camp.playmoney.ui.CreateAccount
import br.com.ioasys.camp.playmoney.ui.ForgotPassword
import br.com.ioasys.camp.playmoney.ui.HomePage
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInfo: SharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)

        if(userInfo.contains("user_email"))
        {
            val userEmail = userInfo.getString("user_email", "")

            if( userEmail != "" )
            {
                val intent = Intent(this,HomePage::class.java)
                startActivity(intent)
            }
        }
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

        ButtonLogin.setOnClickListener {

            try{
                if(EmailInput.text.toString().equals("") || PasswordInput.text.toString().equals(""))
                {
                    throw Exception("Favor preencher os campos de login e senha!")
                }
                else
                {
                    val call = RetrofitInitializer().userService().login(
                        UserLogin(
                            "",
                            EmailInput.text.toString(),
                            PasswordInput.text.toString()
                        )
                    )

                    call.enqueue(object : Callback<UserLogin> {
                        override fun onResponse(call: Call<UserLogin>, response: Response<UserLogin>)
                        {
                            //println("Resposta OK!")

                            if(response.body()?.email == null)
                            {
                                Toast.makeText(this@MainActivity, "Usuário não encontrado", Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                val user_info: SharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE)

                                val editor = user_info.edit()
                                editor.putString("user_name", response.body()?.name)
                                editor.putString("user_email", response.body()?.email)
                                editor.commit()

                                val intent = Intent(this@MainActivity, HomePage::class.java)
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<UserLogin>, t: Throwable)
                        {
                            //println("Sem resposta!!!")
                            Toast.makeText(this@MainActivity, "Falha ao fazer login, tente novamente!", Toast.LENGTH_LONG).show()
                            Log.e("ERRO ", t?.message)
                        }
                    })
                }
            }
            catch (e: Exception)
            {
                Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}
