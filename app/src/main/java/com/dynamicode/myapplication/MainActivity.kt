package com.dynamicode.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.ThreadPoolExecutor

class MainActivity : AppCompatActivity() {

    private val tag:String = "LDG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag,"MainActivity onCreate...")
        if (intent.flags and Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT != 0) {
            finish()
            return
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"MainActivity onRestart...")

    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"MainActivity onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"MainActivity onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"MainActivity onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"MainActivity onStop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"MainActivity onDestroy...")
    }

    fun jumpSecond(view:View?){
        val intent = Intent()
        intent.setClass(this,ThreeActivity::class.java)
        startActivity(intent)
    }
}
