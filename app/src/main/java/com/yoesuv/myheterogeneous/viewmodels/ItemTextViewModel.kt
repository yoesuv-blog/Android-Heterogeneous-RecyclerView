package com.yoesuv.myheterogeneous.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.myheterogeneous.models.TextModel

class ItemTextViewModel(textModel: TextModel): ViewModel() {

    var fullName: ObservableField<String?> = ObservableField(textModel.fullName)
    var job: ObservableField<String?> = ObservableField(textModel.job)

}