package com.dynamicode.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 *  作者：dragon_ldg
 *  创建日期：2020/12/14
 *  描述：AdActivity
 */
class AdActivity : AppCompatActivity() {
    private val tag:String = "LDG"
    private var mHand:Handler = Handler()
    private var mTime = 3
    private val mRun:Runnable = object :Runnable{
        override fun run() {
            if (mTime == 0)
                innerBack()
            mTime--
            mHand.postDelayed(this,1000L)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad)
        Log.d(tag,"AdActivity onCreate...")
        mHand.removeCallbacks(mRun)
        mHand.postDelayed(mRun,1000L)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"AdActivity onRestart...")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"AdActivity onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"AdActivity onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"AdActivity onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"AdActivity onStop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"AdActivity onDestroy...")
    }

    fun backMain(view: View?){
        mHand.removeCallbacks(mRun)
        innerBack()
    }

    fun innerBack(){
        finish()
    }}
