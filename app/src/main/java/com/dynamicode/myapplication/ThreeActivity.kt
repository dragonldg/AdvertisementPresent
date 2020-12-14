package com.dynamicode.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class ThreeActivity : AppCompatActivity() {
    private val tag:String = "LDG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)
        Log.d(tag,"ThreeActivity onCreate...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"ThreeActivity onRestart...")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"ThreeActivity onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"ThreeActivity onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"ThreeActivity onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"ThreeActivity onStop...")
        //添加计时器，比如1分钟之后
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"ThreeActivity onDestroy...")
    }

    fun backMain(view :View){
        finish()
    }
}
