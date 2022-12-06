package com.comet.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.comet.testapplication.callback.Callback

class MainActivity : AppCompatActivity(), Callback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.frame, FirstFragment.newInstance()).commit()
    }

    override fun changeView() {
        supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.frame, SecondFragment()).commit();
    }
}