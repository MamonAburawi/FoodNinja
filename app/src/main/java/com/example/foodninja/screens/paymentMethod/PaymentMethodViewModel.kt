package com.example.foodninja.screens.paymentMethod

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodninja.data.User
import com.example.foodninja.screens.signUpProcess.SignUpProcessArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PaymentMethodViewModel @Inject constructor(
    stateHandle: SavedStateHandle
): ViewModel(){

    private val _user = MutableStateFlow(User())
    val user = _user.asStateFlow()

    init {
        _user.value = SignUpProcessArgs(savedStateHandle = stateHandle).user
    }

}