package com.dicoding.dinoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ivSpalsh = findViewById<ImageView>(R.id.iv_splash)
        ivSpalsh.alpha = 0f
        ivSpalsh.animate().setDuration(1500).alpha(1f).withEndAction{
            val intentStart = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intentStart)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}