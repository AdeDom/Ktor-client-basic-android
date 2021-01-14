package com.adedom.thepharakacc.presentation.ktorclient

import android.os.Bundle
import android.util.Log
import com.adedom.thepharakacc.R
import com.adedom.thepharakacc.base.BaseActivity
import com.adedom.thepharakacc.model.BaseResponse
import com.adedom.thepharakacc.model.FullNameRequest
import com.adedom.thepharakacc.network.HttpClient
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.http.content.*
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class KtorClientActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ktor_client)

        // query
        launch {
            val query1 = "Ade"
            val query2 = "Dom"

            val response: BaseResponse = HttpClient.getHttpClientOkHttp()
                .get("http://192.168.43.22:8080/api/get/query?query1=$query1&query2=$query2")

            Log.d(TAG, "onCreate: ${response.message}")
        }

        // path
        launch {
            val path1 = "Hello"
            val path2 = "World"

            val response: BaseResponse = HttpClient.getHttpClientOkHttp()
                .get("http://192.168.43.22:8080/api/get/path/$path1/$path2")

            Log.d(TAG, "onCreate: ${response.message}")
        }

        // form
        launch {
            val form1 = "AdeDom"
            val form2 = "Jaiyen"

            val response: BaseResponse = HttpClient.getHttpClientOkHttp()
                .post("http://192.168.43.22:8080/api/post/form") {
                    body = MultiPartFormDataContent(formData {
                        append("form1", form1)
                        append("form2", form2)
                    })
                }

            Log.d(TAG, "onCreate: ${response.message}")
        }

        // body
        launch {
            val request = FullNameRequest("Pathiphon", "Jaiyen")

            val response: BaseResponse = HttpClient.getHttpClientOkHttp()
                .post("http://192.168.43.22:8080/api/post/body") {
                    body = TextContent(
                        text = Json.encodeToString(request),
                        contentType = ContentType.Application.Json
                    )
                }

            Log.d(TAG, "onCreate: ${response.message}")
        }
    }

    companion object {
        private const val TAG = "KtorClientActivity"
    }

}
