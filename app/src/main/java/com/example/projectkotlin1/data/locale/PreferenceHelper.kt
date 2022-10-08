package com.example.projectkotlin1.data.locale

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

      private var sharedPreference: SharedPreferences =
          context.getSharedPreferences("onBoard",Context.MODE_PRIVATE)


    fun isShown() : Boolean {
        return  sharedPreference.getBoolean("key", false)
    }

    fun putValue(boolean: Boolean) {
       sharedPreference.edit().putBoolean("key",boolean)?.apply()
    }
}