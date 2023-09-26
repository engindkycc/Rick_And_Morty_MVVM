package com.engindkycc.rickandmortymvvm.view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.engindkycc.rickandmortymvvm.R
import com.engindkycc.rickandmortymvvm.databinding.ActivitySplashScreenBinding

@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private val splashScreenDelay = 5000
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedEditor: Editor

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Dark Mode Disable

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        //Animation setup

        val animationImage = AnimationUtils.loadAnimation(this, R.anim.splash_screen_logo)
        val animationText  = AnimationUtils.loadAnimation(this, R.anim.splash_screen_text)

        val splashImage = binding.splashLogo
        val splashText  = binding.splashText

        splashImage.animation = animationImage
        splashText.animation  = animationText

        //Splash Screen create

        Handler().postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        },splashScreenDelay.toLong())

        //SharedPrefences defination

        sharedPreferences = getPreferences(MODE_PRIVATE)
        sharedEditor = sharedPreferences.edit()
        val loginCheck = findViewById<TextView>(R.id.splashText)

        //Checking if the application is opened for the first time
        if(firstTimeWorkCheck()){

            loginCheck.text = "Welcome!"

        } else {

            loginCheck.text = "Hello!"
        }

    }

        //FirstTimeWorkCheck function
        private fun firstTimeWorkCheck() : Boolean {

            return if (sharedPreferences.getBoolean("firstTime",true)){
                sharedEditor.putBoolean("firstTime",false)
                sharedEditor.commit()
                sharedEditor.apply()
                true

            } else  {

                false
            }

        }

}