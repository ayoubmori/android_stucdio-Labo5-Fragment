package com.adia.laboratoire1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class StaticHostActivity : AppCompatActivity(),ColoringFragment.OnColoringFragmentInteractionListener {
    private lateinit var coloringFragment: ColoringFragment
    private lateinit var coloredFragment: ColoredFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coloringFragment = supportFragmentManager.findFragmentById(R.id.coloringFragment) as ColoringFragment
        coloredFragment = supportFragmentManager.findFragmentById(R.id.coloredFragment) as ColoredFragment
    }
    override fun onSendColorFragmentInteraction(bgColor: Int) {
        Log.i(javaClass.simpleName, "onSendColorFragmentInteraction")
        coloredFragment.setLayoutBackgroundColor(bgColor)
    }

    override fun onChangeFragment() {
       // supportFragmentManager.beginTransaction()
         //   .replace(R.id.topLinearLayout, ReplacingFragment())
           // .addToBackStack(null)
            //.commit()
    }


}