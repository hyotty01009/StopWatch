package com.example.myapplication

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {
    val time: MutableLiveData<String> = MutableLiveData("00:00:00")
    var timer: Timer? = null
    val handler = Handler()
    var count = 0
    val hantei: MutableLiveData<String> = MutableLiveData("start")


    fun start() {
        hantei.postValue("start")

        timer ?: run {
            timer = Timer()

            timer!!.schedule(object : TimerTask() {
                override fun run() {
                    handler.post {
                        count++
                        if (count == 0) {
                            time.postValue("00:00:00")
                        } else {
                            val h = count / 3600
                            val m = count % 3600 / 60
                            val s = count % 60
                            time.postValue("%1$02d:%2$02d:%3$02d".format(h, m, s))

                        }


                    }
                }
            }, 0, 1000)

        }

    }

    fun stop() {
        timer?.let {
            hantei.postValue("restart")
            timer!!.cancel();
            timer = null;
        }
    }

    fun reset() {
        timer?.let {
            count = 0
            timer!!.cancel();
            timer = null;
            time.postValue("00:00:00")
            hantei.postValue("start")
        } ?: run {
            count = 0
            time.postValue("00:00:00")
            hantei.postValue("start")
        }
    }

    /*fun timeToText(time: Int = 0): String? {
       // if式は値を返すため、そのままreturnできる
       return if (time < 0) {
           null
       } else if (time == 0) {
           "00:00:00"
       } else {
           val h = time / 3600
           val m = time % 3600 / 60
           val s = time % 60
           "%1$02d:%2$02d:%3$02d".format(h, m, s)
       }*/

}






