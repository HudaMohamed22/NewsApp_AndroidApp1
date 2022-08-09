package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.myapplication.ui.BlankFragment
import com.example.myapplication.ui.BlankFragment2

class MainActivity : AppCompatActivity() {
    lateinit var registerButton : Button
    lateinit var loginButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerButton =findViewById(R.id.button3)
        registerButton.setOnClickListener{
            Register()
        }
        loginButton = findViewById(R.id.button)
        loginButton.setOnClickListener(){
            Login()
        }

//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<BlankFragment2>(R.id.fragment2)
//            }
//        }

    }
    private fun Register(){
        val intent = Intent(this,RegistrationActivity::class.java)
        startActivity(intent)
    }
    private fun Login(){
        val intent = Intent(this,ItemsShowActivity::class.java)
        startActivity(intent)
    }

}