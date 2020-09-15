package club.csiqu.learnweb.common.autowire.retrofit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
@Configuration
@Import(RetrofitScannerConfigurer.class)
public class RetrofitAutoConfiguration {


}