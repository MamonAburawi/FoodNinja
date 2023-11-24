package com.example.foodninja.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.foodninja.data.User
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class SharePrefApp @Inject constructor(
    @ApplicationContext context: Context
){

    private val pref = context.getSharedPreferences("FoodNinja5", MODE_PRIVATE)
    private val editor = pref.edit()

    fun isOpenBefore(): Boolean = pref.getBoolean(KEY_FIRST_OPEN, false)

    fun trackFirstOpen(){
        editor.putBoolean(KEY_FIRST_OPEN,true)
        editor.apply()
    }

    fun saveSharePreUser(user: User){
        val stringJson = user.toJson()
        editor.putString(KEY_USER, stringJson)
        editor.apply()
    }

    fun clearPref(){
        editor.clear()
        editor.apply()
    }

    fun getSharePrefUser() = checkNotNull(pref.getString(KEY_USER,User().toJson())?.fromJson(User::class.java))

    companion object{
        private const val KEY_FIRST_OPEN = "FirstOpen"
        private const val KEY_USER = "UserPref"
    }
}