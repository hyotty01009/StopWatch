package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //val handler = Handler()

    //var timeValue = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main) as ActivityMainBinding
        val viewModel = MainViewModel()
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        //変数
        /*val timeText = findViewById(R.id.timeText) as TextView
        val startButton = findViewById(R.id.start) as Button
        val stopButton = findViewById(R.id.stop) as Button
        val resetButton = findViewById(R.id.reset) as Button


            }
        }*/
    }


}





