package club.csiqu.learnweb.common.autowire.retrofit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Siqu Chen 2020/9/15
 * @since 1.0
 */
public class ClassPathRetrofitScanner extends ClassPathBeanDefinitionScanner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassPathRetrofitScanner.class);

    public ClassPathRetrofitScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(RetrofitService.class));
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            String packages = Arrays.toString(basePackages);
            LOGGER.warn("No Retrofit service was found in ' {} ' package. Please check your configuration.",
                    packages);
        } else {
            processBeanDefinitions(beanDefinitions);
        }
        return beanDefinitions;
    }

    @Override
    public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface()
                && beanDefinition.getMetadata().hasAnnotation(RetrofitService.class.getName());
    }

    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
        ScannedGenericBeanDefinition definition;
        for (BeanDefinitionHolder holder : beanDefinitions) {
            definition = (ScannedGenericBeanDefinition) holder.getBeanDefinition();
            definition.getPropertyValues().add("retrofitInterface", definition.getBeanClassName());
            definition.getPropertyValues().add("baseUrl",
                    definition.getMetadata().getAnnotationAttributes(RetrofitService.class.getName()).get("baseUrl"));
            definition.setBeanClass(RetrofitFactoryBean.class);
        }
    }
}