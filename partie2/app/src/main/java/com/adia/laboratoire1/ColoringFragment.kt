package com.adia.laboratoire1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import kotlin.random.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColoringFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */


class ColoringFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mListener: OnColoringFragmentInteractionListener
    private val TAG = ColoringFragment::class.java.canonicalName

    private lateinit var coloringFragmentLayout: FrameLayout
    private lateinit var btnReplace: Button

    fun enableReplaceFragmentButton() {
        btnReplace.visibility = View.VISIBLE
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ColoringFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ColoringFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    interface OnColoringFragmentInteractionListener{
        fun onSendColorFragmentInteraction(color:Int)

         fun onChangeFragment()
        }





    //   ------  Voia sycle de vie d'une fragment avec modification dans chaque methode  ---voir Logcat


    override fun onAttach(context: Context) { super.onAttach(context)
        Log.i("Main", "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
        try {
            // Set the OnColoringFragmentInteractionListener for communicating with the hosting Activity
            mListener = context as
                    OnColoringFragmentInteractionListener
        } catch (e: ClassCastException) { throw
        ClassCastException("$context must implement OnColoringFragmentInteractionListener") }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }




        Log.i("Coloring fragment ", "onCreate")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize views or perform other setup here...
       // btnReplace = view.findViewById(R.id.btnReplaceFragment)
       // btnReplace.setOnClickListener { mListener.onChangeFragment()
        }





override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    // Inflate the layout for this fragment
   val coloringFragmentLayout = inflater.inflate(R.layout.fragment_coloring, container, false)
    val message = arguments?.getString("ARG_PARAM1")
    val txt=coloringFragmentLayout.findViewById<TextView>(R.id.showText)
    txt.text=message

    // Initialize btnReplace
     btnReplace = coloringFragmentLayout.findViewById<Button>(R.id.btnReplaceFragment)
    btnReplace.setOnClickListener { mListener.onChangeFragment() }


    coloringFragmentLayout.setOnClickListener {
        // Envoyer une couleur à un autre fragment
        mListener.onSendColorFragmentInteraction(Random.nextInt())
    }

    return coloringFragmentLayout
}




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "${javaClass.simpleName}: entered ${
            object {}.javaClass.enclosingMethod?.name
        }")
    }

}