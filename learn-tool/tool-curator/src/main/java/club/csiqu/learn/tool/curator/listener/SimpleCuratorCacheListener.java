package club.csiqu.learn.tool.curator.listener;

import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siqu Chen 2020/9/21
 * @since 1.0
 */
public class SimpleCuratorCacheListener implements CuratorCacheListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCuratorCacheListener.class);

    @Override
    public void event(Type type, ChildData oldData, ChildData data) {
        if (type.equals(CuratorCacheListener.Type.NODE_CREATED)) {
            LOGGER.info("Node created: {}", data);
        }
    }
}