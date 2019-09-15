package com.yoesuv.myheterogeneous.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yoesuv.myheterogeneous.models.ImageModel

class ItemImageViewModel(imageModel: ImageModel): ViewModel() {
    var name: ObservableField<String?> = ObservableField(imageModel.name)
    var imageUrl: ObservableField<String?> = ObservableField(imageModel.imageUrl)
}