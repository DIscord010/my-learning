package club.csiqu.learn.tool.curator.example;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.KeeperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Siqu Chen 2020/8/4
 * @since 1.0
 */
public class CuratorTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(CuratorTemplate.class);

    private final CuratorFramework client;

    public CuratorTemplate(String address) {
        RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
        this.client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        this.client.start();
    }

    /**
     * 展示当前节点下所有节点信息
     */
    public List<String> listByNode(String nodePath) throws Exception {
        return this.client.getChildren().forPath(nodePath);
    }

    public void createNode(String path) {
        try {
            this.client.create().forPath(path);
        } catch (KeeperException.NodeExistsException e) {
            LOGGER.warn("ZNode {} already exists.", path, e);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public void addListener(String path, CuratorCacheListener listener) {
        CuratorCache cache = CuratorCache.builder(client, path).build();
        cache.listenable().addListener(listener);
        cache.start();
    }

    public void close() {
        this.client.close();
    }
}