package br.com.ioasys.camp.playmoney.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ioasys.camp.playmoney.R
import br.com.ioasys.camp.playmoney.MainActivity
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_create_account.*


class CreateAccount :  AppCompatActivity() {

    var GenderArray = arrayOf("Feminino","Masculino", "Outro")
    var genderSelected = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

    }
    override fun onStart() {
        super.onStart()

        val spinner : Spinner = this.findViewById(R.id.GenderSpinner)
        val adapter = ArrayAdapter(this,R.layout.spinner_layout, GenderArray )
        spinner.adapter=adapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                genderSelected=position
            }

        }

        ButtonBackLogin.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ButtonNextPage.setOnClickListener(){
            val intent = Intent(this, CreatePassword::class.java)
            startActivity(intent)
        }
    }
}