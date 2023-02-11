package com.example.webcontrolchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webcontrolchallenge.adapter.UserAdapter
import com.example.webcontrolchallenge.data.APIPlatzi
import com.example.webcontrolchallenge.data.RetrofitHelper
import com.example.webcontrolchallenge.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
                setContentView(binding.root)

        val quotesApi = RetrofitHelper.getInstance().create(APIPlatzi::class.java)
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            val listUser = result.body()
            runOnUiThread {
                listUser?.let { list->
                    val adapter = UserAdapter(list)
                    binding.rvListItem.adapter = adapter
                }
            }
        }
    }

}