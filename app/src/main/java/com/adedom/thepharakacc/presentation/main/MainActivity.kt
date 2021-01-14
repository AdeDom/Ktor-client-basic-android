package com.adedom.thepharakacc.presentation.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.thepharakacc.R
import com.adedom.thepharakacc.base.BaseActivity
import com.adedom.thepharakacc.model.StaffResponse
import com.adedom.thepharakacc.network.HttpClient
import com.bumptech.glide.Glide
import io.ktor.client.request.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val mAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = mAdapter
        }

        launch {
            val response: StaffResponse = HttpClient.getHttpClientOkHttp()
                .get("http://192.168.43.22:8080/api/thepharak-acc/staff")

            Glide.with(imageView)
                .load(response.logo)
                .into(imageView)

            mAdapter.setList(response.staffList)
        }
    }

}
