package com.example.newtine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtine.databinding.ActivityMainBinding
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import org.jsoup.Jsoup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://news.google.com/")
        .addConverterFactory(
            TikXmlConverterFactory.create(
                TikXml.Builder()
                    .exceptionOnUnreadXml(false)
                    .build()
            )
        ).build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        newsAdapter = NewsAdapter()

        val newsService = retrofit.create(NewsService::class.java)

        binding.newRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }

        binding.ItChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.ItChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.itNews().submitList()
        }
        binding.politicsChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.politicsChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.politicsNews().submitList()
        }
        binding.economicChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.economicChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.economicNews().submitList()
        }
        binding.industryChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.industryChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.industryNews().submitList()
        }
        binding.socialChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.socialChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.socialNews().submitList()
        }
        binding.cultureChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.cultureChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.cultureNews().submitList()
        }
        binding.sportsChip.setOnClickListener{
            binding.chipGroup.clearCheck()//다른 칩 체크 해제시킴
            binding.sportsChip.isChecked = true

            //todo api 호출, 리스트를 변경
            newsService.sportsNews().submitList()
        }

    }

    private fun Call<NewsRss>.submitList() {
        enqueue(object: Callback<NewsRss> {
            override fun onResponse(call: Call<NewsRss>, response: Response<NewsRss>) {
                Log.e("MainActivity","${response.body()?.channel?.items}")

                val list = response.body()?.channel?.items.orEmpty().transform()
                newsAdapter.submitList(list)

                list.forEachIndexed { index,news ->
                    //og:image meta에서 가져오기
                    Thread {
                        try{
                            val jsoup = Jsoup.connect(news.link).get()
                            val elements = jsoup.select("meta[property^=og:]")
                            val ogImageNode = elements.find { node ->
                                node.attr("property") == "og:image"
                            }

                            news.imageUrl = ogImageNode?.attr("content")
                            Log.e("MainActivity","imageUrl: ${news.imageUrl}")

                        }catch (e: Exception){
                            e.printStackTrace()
                        }

                        runOnUiThread {
                            newsAdapter.notifyItemChanged(index)
                        }
                    }.start()

                }
            }
            override fun onFailure(call: Call<NewsRss>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }
}