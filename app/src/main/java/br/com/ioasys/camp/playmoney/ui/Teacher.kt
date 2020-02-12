package br.com.ioasys.camp.playmoney.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.ioasys.camp.playmoney.R
import kotlinx.android.synthetic.main.activity_home_page.*
import kotlinx.android.synthetic.main.activity_teacher.*

class Teacher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
    }

    override fun onStart() {
        super.onStart()
        ButtonBackGame.setOnClickListener(){
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}