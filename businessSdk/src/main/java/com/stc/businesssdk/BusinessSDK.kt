package com.stc.businesssdk

import com.stc.businesssdk.fragment.SdkFragment2
import com.stc.businesssdk.interfaces.BusinessSDKCallback

class BusinessSDK {
    fun loadSdkFragment(param1: String, param2: String, callback: BusinessSDKCallback) {
        // Generate the Fragment
        val fragment = SdkFragment2.newInstance(param1, param2)
        // Notify the super app
        fragment.setCallback(callback)
        callback.onFragmentReceived(fragment)
    }

}