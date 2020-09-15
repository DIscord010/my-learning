package club.csiqu.learnweb.common.autowire.retrofit;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
public class RetrofitScannerConfigurer implements BeanFactoryPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        ClassPathRetrofitScanner scanner = new ClassPathRetrofitScanner((BeanDefinitionRegistry) configurableListableBeanFactory);
        scanner.setResourceLoader(this.applicationContext);
        scanner.scan("club.csiqu.learnweb.module.retrofit.manager");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}