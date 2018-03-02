package com.royrine.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    private val splash_Display_Lenght = 3500L

    lateinit var ivLogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ivLogo = findViewById(R.id.ivLogo)
        carregar()
    }

    fun carregar(){
        val anim = AnimationUtils.loadAnimation(this, R.anim.abc_fade_in)
        anim.reset()

        ivLogo!!.clearAnimation()
        ivLogo!!.startAnimation(anim)

        Handler().postDelayed({
            //Após o tempo definido irá execurar a próxima tela
            val intent = Intent(this@SplashActivity, FormActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            this@SplashActivity.finish()
        }, splash_Display_Lenght)
    }
}
