package com.adia.GG220Labo1Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private val YES = 0
private val NO = 1

/**
 * A simple [Fragment] subclass.
 * Use the [SimpleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SimpleFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =inflater.inflate(R.layout.fragment_simple,container,false)
        val radioGroup =rootView.findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener {
                group, checkedId ->
            val radioButton: View = radioGroup.findViewById<View>(checkedId)
            val index: Int = radioGroup.indexOfChild(radioButton)
            val textView: TextView = rootView.findViewById<TextView>(R.id.fragment_header)
            when (index) {
            YES -> textView.setText(R.string.yes_message)
            NO -> textView.setText(R.string.no_message)
            else-> {
            }
        } })
    return rootView



       // return inflater.inflate(R.layout.fragment_simple, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SimpleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SimpleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}