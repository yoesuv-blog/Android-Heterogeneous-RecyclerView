package com.yoesuv.myheterogeneous.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoesuv.myheterogeneous.R
import com.yoesuv.myheterogeneous.adapters.MyListAdapter
import com.yoesuv.myheterogeneous.databinding.ActivityMainBinding
import com.yoesuv.myheterogeneous.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var myAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()

        viewModel.setupData()
        viewModel.listHeterogeneous.observe(this, Observer {
            myAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        val lManager = LinearLayoutManager(this)
        myAdapter = MyListAdapter()
        binding.recyclerViewMain.apply {
            this.layoutManager = lManager
            this.adapter = myAdapter
        }
    }
}
