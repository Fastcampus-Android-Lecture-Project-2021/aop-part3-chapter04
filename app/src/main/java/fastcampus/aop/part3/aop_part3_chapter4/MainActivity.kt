package fastcampus.aop.part3.aop_part3_chapter4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fastcampus.aop.part3.aop_part3_chapter4.adapter.BookAdapter
import fastcampus.aop.part3.aop_part3_chapter4.api.BookAPI
import fastcampus.aop.part3.aop_part3_chapter4.databinding.ActivityMainBinding
import fastcampus.aop.part3.aop_part3_chapter4.model.BestSellerDto
import fastcampus.aop.part3.aop_part3_chapter4.model.SearchBooksDto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = BookAdapter()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(BookAPI::class.java)
        service.getBestSeller(getString(R.string.interpark_apikey))
            .enqueue(object: Callback<BestSellerDto> {
                override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {

                }

                override fun onResponse(call: Call<BestSellerDto>, response: Response<BestSellerDto>) {
                    if (response.isSuccessful.not()) {
                        return
                    }

                    response.body()?.let {
                        Log.d(TAG, it.toString())

                        it.books.forEach { book ->
                            Log.d(TAG, book.toString())
                        }

                        adapter.submitList(it.books)
                    }
                }

            })

        service.getBooksByName(getString(R.string.interpark_apikey), "달러구트")
            .enqueue(object: Callback<SearchBooksDto> {
                override fun onFailure(call: Call<SearchBooksDto>, t: Throwable) {

                }

                override fun onResponse(call: Call<SearchBooksDto>, response: Response<SearchBooksDto>) {
                    if (response.isSuccessful.not()) {
                        return
                    }

                    response.body()?.let {
                        Log.d(TAG, it.toString())

                        it.books.forEach { book ->
                            Log.d(TAG, book.toString())
                        }
                    }
                }

            })

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

//        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(this)
//        findViewById<RecyclerView>(R.id.recyclerView).adapter = adapter



    }

    companion object {
        private const val TAG = "MainActivity"
        private const val BASE_URL = "https://book.interpark.com/"
    }
}