package com.example.foodninja.screens.signUpProcess

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodninja.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpProcessViewModel @Inject constructor (
    private val savedState: SavedStateHandle
): ViewModel() {

    private val _user = MutableStateFlow(User())
    val user = _user.asStateFlow()


    init {
        _user.value = SignUpProcessArgs(savedStateHandle = savedState).user
    }

    fun updateUser(user: User) {
        _user.value = user
    }


}