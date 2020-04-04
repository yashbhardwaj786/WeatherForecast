package com.example.weatherandroidassignment.databinding;
import com.example.weatherandroidassignment.R;
import com.example.weatherandroidassignment.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LayoutCommonErrorBindingImpl extends LayoutCommonErrorBinding implements com.example.weatherandroidassignment.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.iv_some_illustration, 4);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView3;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LayoutCommonErrorBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private LayoutCommonErrorBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[2]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[1]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.LinearLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.tvSomeMessage.setTag(null);
        this.tvSomeTitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.weatherandroidassignment.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.errorModel == variableId) {
            setErrorModel((com.example.weatherandroidassignment.ui.viewmodel.ErrorModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setErrorModel(@Nullable com.example.weatherandroidassignment.ui.viewmodel.ErrorModel ErrorModel) {
        updateRegistration(0, ErrorModel);
        this.mErrorModel = ErrorModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.errorModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeErrorModel((com.example.weatherandroidassignment.ui.viewmodel.ErrorModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeErrorModel(com.example.weatherandroidassignment.ui.viewmodel.ErrorModel ErrorModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.errorTitle) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.errorSubTitle) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.weatherandroidassignment.ui.viewmodel.ErrorModel errorModel = mErrorModel;
        java.lang.String errorModelErrorSubTitle = null;
        java.lang.String errorModelErrorTitle = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (errorModel != null) {
                        // read errorModel.errorSubTitle
                        errorModelErrorSubTitle = errorModel.getErrorSubTitle();
                    }
            }
            if ((dirtyFlags & 0xbL) != 0) {

                    if (errorModel != null) {
                        // read errorModel.errorTitle
                        errorModelErrorTitle = errorModel.getErrorTitle();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView3.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSomeMessage, errorModelErrorSubTitle);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvSomeTitle, errorModelErrorTitle);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // errorModel.errorActionListener != null
        boolean errorModelErrorActionListenerJavaLangObjectNull = false;
        // errorModel.errorActionListener
        com.example.weatherandroidassignment.ui.viewmodel.ErrorActionListener errorModelErrorActionListener = null;
        // errorModel != null
        boolean errorModelJavaLangObjectNull = false;
        // errorModel
        com.example.weatherandroidassignment.ui.viewmodel.ErrorModel errorModel = mErrorModel;



        errorModelJavaLangObjectNull = (errorModel) != (null);
        if (errorModelJavaLangObjectNull) {


            errorModelErrorActionListener = errorModel.getErrorActionListener();

            errorModelErrorActionListenerJavaLangObjectNull = (errorModelErrorActionListener) != (null);
            if (errorModelErrorActionListenerJavaLangObjectNull) {


                errorModelErrorActionListener.onErrorActionClicked();
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): errorModel
        flag 1 (0x2L): errorModel.errorTitle
        flag 2 (0x3L): errorModel.errorSubTitle
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}