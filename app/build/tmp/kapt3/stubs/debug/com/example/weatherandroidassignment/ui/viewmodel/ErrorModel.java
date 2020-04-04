package com.example.weatherandroidassignment.ui.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u0003H\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003R*\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\bR*\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\n8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR*\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0004\u00a8\u0006!"}, d2 = {"Lcom/example/weatherandroidassignment/ui/viewmodel/ErrorModel;", "Landroidx/databinding/BaseObservable;", "visibility", "", "(Z)V", "()V", "errorActionListener", "Lcom/example/weatherandroidassignment/ui/viewmodel/ErrorActionListener;", "(Lcom/example/weatherandroidassignment/ui/viewmodel/ErrorActionListener;)V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "buttonVisibility", "getButtonVisibility", "()Z", "setButtonVisibility", "getErrorActionListener", "()Lcom/example/weatherandroidassignment/ui/viewmodel/ErrorActionListener;", "setErrorActionListener", "errorSubTitle", "getErrorSubTitle", "setErrorSubTitle", "errorTitle", "getErrorTitle", "setErrorTitle", "getVisibility$app_debug", "setVisibility$app_debug", "getVisibility", "setVisibility", "", "app_debug"})
public final class ErrorModel extends androidx.databinding.BaseObservable {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String errorTitle;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String errorSubTitle;
    private boolean visibility;
    private boolean buttonVisibility;
    @org.jetbrains.annotations.Nullable()
    private com.example.weatherandroidassignment.ui.viewmodel.ErrorActionListener errorActionListener;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String buttonText;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final java.lang.String getErrorTitle() {
        return null;
    }
    
    public final void setErrorTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String errorTitle) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final java.lang.String getErrorSubTitle() {
        return null;
    }
    
    public final void setErrorSubTitle(@org.jetbrains.annotations.Nullable()
    java.lang.String errorSubTitle) {
    }
    
    public final boolean getVisibility$app_debug() {
        return false;
    }
    
    public final void setVisibility$app_debug(boolean p0) {
    }
    
    @androidx.databinding.Bindable()
    public final boolean getButtonVisibility() {
        return false;
    }
    
    public final void setButtonVisibility(boolean buttonVisibility) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.weatherandroidassignment.ui.viewmodel.ErrorActionListener getErrorActionListener() {
        return null;
    }
    
    public final void setErrorActionListener(@org.jetbrains.annotations.Nullable()
    com.example.weatherandroidassignment.ui.viewmodel.ErrorActionListener p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final java.lang.String getButtonText() {
        return null;
    }
    
    public final void setButtonText(@org.jetbrains.annotations.Nullable()
    java.lang.String buttonText) {
    }
    
    @androidx.databinding.Bindable()
    public final boolean getVisibility() {
        return false;
    }
    
    public final void setVisibility(boolean visibility) {
    }
    
    public ErrorModel(boolean visibility) {
        super();
    }
    
    public ErrorModel() {
        super();
    }
    
    public ErrorModel(@org.jetbrains.annotations.NotNull()
    com.example.weatherandroidassignment.ui.viewmodel.ErrorActionListener errorActionListener) {
        super();
    }
}