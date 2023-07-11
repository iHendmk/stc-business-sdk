package com.stc.businesssdk.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.stc.businesssdk.interfaces.BusinessSDKCallback
import com.stc.businesssdk.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SdkFragment2 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var callback: BusinessSDKCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    fun setCallback(callback: BusinessSDKCallback) {
        this.callback = callback
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sdk2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = view.findViewById<TextView>(R.id.idTVHeading)
            text.setOnClickListener {
            callback?.let {
                it.onTextClicked(text.text.toString())
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SdkFragment2.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SdkFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}