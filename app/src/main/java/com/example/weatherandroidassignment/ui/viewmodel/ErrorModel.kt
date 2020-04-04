package com.example.weatherandroidassignment.ui.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class ErrorModel: BaseObservable {

    @get:Bindable
    var errorTitle: String? = null
        set(errorTitle) {
            field = errorTitle
            notifyPropertyChanged(BR.errorTitle)
        }
    @get:Bindable
    var errorSubTitle: String? = null
        set(errorSubTitle) {
            field = errorSubTitle
            notifyPropertyChanged(BR.errorSubTitle)
        }
    internal var visibility = true
    @get:Bindable
    var buttonVisibility = false
        set(buttonVisibility) {
            field = buttonVisibility
            notifyPropertyChanged(BR.buttonVisibility)
        }
    var errorActionListener: ErrorActionListener? = null
    @get:Bindable
    var buttonText: String? = null
        set(buttonText) {
            field = buttonText
            notifyPropertyChanged(BR.buttonText)
        }

    constructor(visibility: Boolean) {
        this.visibility = visibility
    }

    constructor()

    constructor(errorActionListener: ErrorActionListener) {
        this.errorActionListener = errorActionListener
    }

    @Bindable
    fun getVisibility(): Boolean {
        return visibility
    }

    fun setVisibility(visibility: Boolean) {
        this.visibility = visibility
        notifyPropertyChanged(BR.visibility)
    }
}