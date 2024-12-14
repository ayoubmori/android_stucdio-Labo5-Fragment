package com.adia.laboratoire1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DynamicHostActivity : AppCompatActivity() ,ColoringFragment.OnColoringFragmentInteractionListener{
    private lateinit var dynamicColoredFragment: ColoredFragment
    private lateinit var dynamicColoringFragment: ColoringFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_host)
        dynamicColoringFragment = ColoringFragment.newInstance("", "")
        dynamicColoredFragment = ColoredFragment.newInstance("", "")

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.topLinearLayout, dynamicColoringFragment)
        fragmentTransaction.add(R.id.bottomLinearLayout, dynamicColoredFragment)
        fragmentTransaction.commit()


    }
    override fun onResume() {
            super.onResume()
        dynamicColoringFragment.enableReplaceFragmentButton()
    }

    override fun onSendColorFragmentInteraction(color: Int) {
        dynamicColoredFragment.setLayoutBackgroundColor(color)
    }


    override fun onChangeFragment() {
        val replacingFragment = ReplacingFragment.newInstance("Hello from replacing fragment", "")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottomLinearLayout, replacingFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}