package com.example.foodninja

import androidx.lifecycle.ViewModel
import com.example.foodninja.data.User
import com.example.foodninja.utils.SharePrefApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SharedViewModel
    @Inject constructor(
        private val sharePrefApp: SharePrefApp
    ): ViewModel() {

    private val _user = MutableStateFlow(User())
    val user = _user.asStateFlow()

    init {
        _user.value = getUserFromPref()
    }

    fun updateUser(user: User){
        sharePrefApp.saveSharePreUser(user)
    }



    private fun getUserFromPref() = sharePrefApp.getSharePrefUser()

}