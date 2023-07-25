package com.example.newtine

import retrofit2.Call
import retrofit2.http.GET

interface NewsService {
    @GET("rss/topics/CAAqKAgKIiJDQkFTRXdvSkwyMHZNR1ptZHpWbUVnSnJieG9DUzFJb0FBUAE?hl=ko&gl=KR&ceid=KR%3Ako")
    fun itNews(): Call<NewsRss>

    @GET("rss/topics/CAAqIQgKIhtDQkFTRGdvSUwyMHZNRFZ4ZERBU0FtdHZLQUFQAQ?hl=ko&gl=KR&ceid=KR%3Ako")
    fun politicsNews(): Call<NewsRss>

    @GET("rss/topics/CAAqIggKIhxDQkFTRHdvSkwyMHZNR2RtY0hNekVnSnJieWdBUAE?hl=ko&gl=KR&ceid=KR%3Ako")
    fun economicNews(): Call<NewsRss>

    @GET("rss/topics/CAAqJAgKIh5DQkFTRUFvS0wyMHZNRGd3Tm1wc2N4SUNhMjhvQUFQAQ?hl=ko&gl=KR&ceid=KR%3Ako")
    fun industryNews(): Call<NewsRss>

    @GET("rss/topics/CAAqIQgKIhtDQkFTRGdvSUwyMHZNRGs0ZDNJU0FtdHZLQUFQAQ?hl=ko&gl=KR&ceid=KR%3Ako")
    fun socialNews(): Call<NewsRss>

    @GET("rss/topics/CAAqIQgKIhtDQkFTRGdvSUwyMHZNREYzY3pVU0FtdHZLQUFQAQ?hl=ko&gl=KR&ceid=KR%3Ako")
    fun cultureNews(): Call<NewsRss>

    @GET("rss/topics/CAAqJggKIiBDQkFTRWdvSUwyMHZNRFp1ZEdvU0FtdHZHZ0pMVWlnQVAB?hl=ko&gl=KR&ceid=KR%3Ako")
    fun sportsNews(): Call<NewsRss>

}