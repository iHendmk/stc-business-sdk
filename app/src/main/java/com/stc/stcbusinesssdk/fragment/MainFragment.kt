package com.stc.stcbusinesssdk.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.stc.businesssdk.BusinessSDK
import com.stc.businesssdk.interfaces.BusinessSDKCallback
import com.stc.stcbusinesssdk.R


class MainFragment : Fragment() {

    private val businessSDK = BusinessSDK()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBusinessSDKFragment()
    }


    private fun showBusinessSDKFragment() {
        businessSDK.loadSdkFragment("", "", object : BusinessSDKCallback {
            override fun onFragmentReceived(fragment: Fragment) {
                val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
                transaction.replace(R.id.childFragmentContainer, fragment).commit()
            }

            override fun onTextClicked(text: String) {
                Toast.makeText(this@MainFragment.requireContext(), text, Toast.LENGTH_SHORT).show()
            }

        })

    }

}