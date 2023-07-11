package com.stc.businesssdk.interfaces

import androidx.fragment.app.Fragment

interface BusinessSDKCallback {
    fun onFragmentReceived(fragment: Fragment)
    fun onTextClicked(text: String)
}