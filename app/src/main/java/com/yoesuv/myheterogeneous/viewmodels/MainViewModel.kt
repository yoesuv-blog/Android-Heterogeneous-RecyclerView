package com.yoesuv.myheterogeneous.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yoesuv.myheterogeneous.models.ImageModel
import com.yoesuv.myheterogeneous.models.TextModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var listHeterogeneous: MutableLiveData<MutableList<Any>> = MutableLiveData()
    private var listData: MutableList<Any> = arrayListOf()

    fun setupData() {
        listData.clear()
        listData.add(ImageModel("Dian Sastro Wardoyo","https://www.unreservedmedia.com/wp-content/uploads/2018/11/dian-sastrowardoryo-ryan-tandya.jpg"))
        listData.add(TextModel("Nicholas Saputra","Artis"))
        listData.add(ImageModel("Chelsea Islan","https://1.bp.blogspot.com/-GMCBs0do1AA/WRaYJS_heyI/AAAAAAAAKbM/4i_XAQ-hjsMHxtLQvUNWNE0rzjQKN-iZwCEw/s1600/islan4.jpg"))
        listData.add(ImageModel("IU","https://www.allkpop.com/upload/2018/10/af_org/27105129/IU.jpg"))
        listData.add(TextModel("Leonel Messi","Atlet Sepakbola"))
        listData.add(ImageModel("Pevita Pearce","https://1.bp.blogspot.com/-dtfgEusKDyg/V8VGxwdHx_I/AAAAAAAALUQ/DOd04r2NBj4kza6SslGpihanSqmnUUKNwCLcB/s1600/pevita%2Bpearce.jpg"))

        listHeterogeneous.postValue(listData)
    }
}