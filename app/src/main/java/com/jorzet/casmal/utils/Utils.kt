package com.jorzet.casmal.utils

import android.util.Log

/**
 * @author Bani Azarael Mejia Flores
 * @email banimejia@codequark.com
 * @date 26/12/19
 */

class Utils {
    companion object {
        const val PROVIDER_FACEBOOK = "Facebook"
        const val PROVIDER_GOOGLE = "Google"

        fun print(TAG: String, text: String) {
            if(text.isEmpty()) {
                return
            }

            Log.d(TAG, text)
        }

        fun print(text: String) {
            if(text.isEmpty()) {
                return
            }

            Log.d("Bani", text)
        }
    }
}