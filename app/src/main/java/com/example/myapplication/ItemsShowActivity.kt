package com.example.myapplication

import CustomAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.ApiResponse
import com.example.myapplication.ui.JasonData
import com.example.myapplication.ui.JasonSource
import com.example.myapplication.ui.service
import com.google.gson.annotations.SerializedName
import com.maximeroussy.invitrode.WordGenerator

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsShowActivity : AppCompatActivity() , Callback<ApiResponse?>,CustomAdapter.OnItemClickListener{
    var adapter : CustomAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_show)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)


        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // This will pass the ArrayList to our Adapter

        var News = generateNews()
        adapter = CustomAdapter(News,this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        GetArticles()


//        // ArrayList of class ItemsViewModel
//        val data = ArrayList<ItemsViewModel>()
//
//        // This loop will create 20 Views containing
//        // the image with the count of view
//        for (i in 1..20) {
//            data.add(ItemsViewModel(R.drawable.ic_dashboard_black_24dp, "Item " + i))
//        }

    }

    private fun generateNews(): Array<JasonData> {
        val generator = WordGenerator()

        return Array(100) {
            JasonData(

                null,
                generator.newWord(10),
                generator.newWord(10),
                generator.newWord(10),
                generator.newWord(10),
                "https://picsum.photos/100/200",
                generator.newWord(10),
                generator.newWord(10)

            )
        }
    }

    fun GetArticles (){
        service.getNews("Apple","4aa91dc386dd44079566dccb9423bc6f")?.enqueue(this)
    }


    override fun onResponse(call: Call<ApiResponse?>, response: Response<ApiResponse?>) {
        adapter?.mList = response.body()?.articles
        adapter?.notifyDataSetChanged()
    }

    override fun onFailure(call: Call<ApiResponse?>, t: Throwable) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(myArtical: JasonData) {
      //  val clicked = adapter?.mList?.get(position)
        if (myArtical != null) {
            Toast.makeText(this, "${myArtical.title} clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(Intent.ACTION_VIEW).setData(myArtical?.url?.toUri()))
        }
    }


}