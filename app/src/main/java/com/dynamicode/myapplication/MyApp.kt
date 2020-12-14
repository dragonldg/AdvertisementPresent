package com.dynamicode.myapplication

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.util.Log


/**
 *  作者：dragon_ldg
 *  创建日期：2020/12/14
 *  描述：MyApp
 */
class MyApp :Application(){
    private var appCount:Int = 0
    private var isRunInBackground:Boolean = false

    override fun onCreate() {
        super.onCreate()
        initBackgroundCallBack()
    }

    private fun initBackgroundCallBack() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {
            }

            override fun onActivityStarted(activity: Activity) {
                appCount++
                if (isRunInBackground) {
                    //应用从后台回到前台 需要做的操作
                    back2App(activity)
                }
            }

            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {
                appCount--
                if (appCount == 0) {
                    //应用进入后台 需要做的操作
                    leaveApp(activity)
                }
            }

            override fun onActivitySaveInstanceState(
                activity: Activity,
                outState: Bundle
            ) {
            }

            override fun onActivityDestroyed(activity: Activity) {}
        })
    }


    /**
     * 从后台回到前台需要执行的逻辑
     *
     * @param activity,点击Launcher上的图标：MainActivity，点击后台列表：进入后台前最后一个前台Activity
     */
    private fun back2App(activity: Activity) {
        isRunInBackground = false
        Log.d("LDG", "$appCount---back2App---$leaveActivity")
        //添加计时器，比如在后台时间超过1分钟之后才显示广告页面
//        if (/*超1分钟*/) {//进入广告页面
//            val intent = Intent()
//            intent.setClass(activity,AdActivity::class.java)
//            startActivity(intent)
//        }else {
            val intent = Intent()//直接回到之前的活动
            intent.setClass(activity, leaveActivity!!.javaClass)
            startActivity(intent)
//        }
    }

    /**
     * 离开应用 压入后台或者退出应用
     *
     * @param activity
     */
    private fun leaveApp(activity: Activity) {
        isRunInBackground = true
        leaveActivity = activity
        Log.d("LDG", "$appCount---leaveApp---$activity")
    }

    companion object{
        var leaveActivity:Activity? = null
    }
}