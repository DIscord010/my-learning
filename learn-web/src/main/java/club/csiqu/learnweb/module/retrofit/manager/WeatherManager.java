package club.csiqu.learnweb.module.retrofit.manager;

import club.csiqu.learnweb.common.autowire.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.HashMap;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
@RetrofitService(baseUrl = "http://tj.nineton.cn/")
public interface WeatherManager {

    /**
     * 根据城市编码获取城市天气
     *
     * @param cityCode 城市编码
     * @return 天气情况
     */
    @GET("/Heart/index/all")
    Call<HashMap<String, Object>> getWeatherByCityCode(@Query("city") String cityCode);
}