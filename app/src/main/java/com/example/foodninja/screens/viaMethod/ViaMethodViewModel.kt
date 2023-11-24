package com.example.foodninja.screens.viaMethod

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViaMethodViewModel @Inject
    constructor(
        stateHandle: SavedStateHandle
    ): ViewModel() {

}