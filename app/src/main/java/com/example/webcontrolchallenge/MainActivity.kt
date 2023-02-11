package com.example.webcontrolchallenge

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.webcontrolchallenge.adapter.UserAdapter
import com.example.webcontrolchallenge.data.APIPlatzi
import com.example.webcontrolchallenge.data.DataBaseWC
import com.example.webcontrolchallenge.data.RetrofitHelper
import com.example.webcontrolchallenge.databinding.ActivityMainBinding
import com.example.webcontrolchallenge.utils.toUserDTO
import com.example.webcontrolchallenge.utils.toUserEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
                setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            DataBaseWC::class.java,
            "wc-challenge")
            .allowMainThreadQueries()
            .build()

        val quotesApi = RetrofitHelper.getInstance().create(APIPlatzi::class.java)
        GlobalScope.launch {
            val userDao = db.userDao()
            val listUserDao = userDao.getAll()
            if (listUserDao.isNotEmpty()){
                Log.e("DbUse","Está Usando Base de Datos")
                val adapter = UserAdapter(listUserDao.map { it.toUserDTO() })
                binding.rvListItem.adapter = adapter
            }
            else {
                val result = quotesApi.getQuotes()
                val listUser = result.body()
                runOnUiThread {
                    listUser?.let { list->
                        list.forEach { item->
                            userDao.insert(item.toUserEntity())
                        }

                        val adapter = UserAdapter(list)
                        binding.rvListItem.adapter = adapter
                    }
                }
                Log.e("APIuse","Está Usando API")
            }

        }
    }

}