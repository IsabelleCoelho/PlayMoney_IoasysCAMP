package br.com.ioasys.camp.playmoney.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.MainActivity
import br.com.ioasys.camp.playmoney.R
import br.com.ioasys.camp.playmoney.RetrofitInitializer
import br.com.ioasys.camp.playmoney.UserCreateAccount
import kotlinx.android.synthetic.main.activity_create_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreatePassword : AppCompatActivity(){

    private var apelido = ""
    private var email = ""
    private var data_nascimento = ""
    private var genero = ""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)

        this.apelido = intent.getStringExtra("apelido")
        this.email = intent.getStringExtra("email")
        this.data_nascimento = intent.getStringExtra("data_nascimento")
        this.genero = intent.getStringExtra("genero")
    }

    override fun onStart(){
        super.onStart()
        ButtonBackCreateAccount.setOnClickListener(){
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }

        ButtonFinish.setOnClickListener {

            try
            {
                if (PasswordInput.text.toString().equals("") || ConfirmPasswordInput.text.toString().equals(""))
                {
                    throw Exception("Favor preencher os campos de senha!")
                }

                if(PasswordInput.text.toString().equals(ConfirmPasswordInput.text.toString()))
                {
                    if(genero == "Feminino")
                    {
                        genero = "F"
                    }
                    else if(genero == "Masculino")
                    {
                        genero = "M"
                    }
                    else if(genero == "Outro")
                    {
                        genero = "O"
                    }
                    val call = RetrofitInitializer().userService().createAccount(UserCreateAccount(apelido, email, data_nascimento, genero, PasswordInput.text.toString()))

                    call.enqueue(object : Callback<UserCreateAccount> {
                        override fun onResponse(call: Call<UserCreateAccount>, response: Response<UserCreateAccount>) {
                            //println("Resposta OK!")

                            if(response.body()?.email == null)
                            {
                                Toast.makeText(this@CreatePassword, "Falha ao cadastrar usuário!", Toast.LENGTH_LONG).show()
                            }
                            else{
                                Toast.makeText(this@CreatePassword, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
                                val intent = Intent(this@CreatePassword, MainActivity::class.java)
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<UserCreateAccount>, t: Throwable) {
                            //println("Sem resposta!!!")
                            Toast.makeText(this@CreatePassword, "Falha ao fazer cadastro, tente novamente!", Toast.LENGTH_LONG).show()
                            Log.e("ERRO ", t?.message)
                        }
                    })
                }
                else
                {
                    throw Exception("As senhas não conferem!")
                }
            }
            catch (e: Exception)
            {
                Toast.makeText(this@CreatePassword, e.message.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }

}