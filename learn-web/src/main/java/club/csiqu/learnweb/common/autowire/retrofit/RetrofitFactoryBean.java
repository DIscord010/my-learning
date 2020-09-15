package club.csiqu.learnweb.common.autowire.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
public class RetrofitFactoryBean<T> implements FactoryBean<T>, InitializingBean {

    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd hh:mm:ss")
            .create();

    private Class<T> retrofitInterface;

    private String baseUrl;

    @Override
    public T getObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(retrofitInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return this.retrofitInterface;
    }

    public void setRetrofitInterface(Class<T> retrofitInterface) {
        this.retrofitInterface = retrofitInterface;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public void afterPropertiesSet() {
        // do nothing
    }
}