package club.csiqu.learn.tool.curator.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

import java.util.List;

/**
 * @author Siqu Chen 2020/8/4
 * @since 1.0
 */
public class CuratorTemplate {

    private final CuratorFramework client;

    public CuratorTemplate(String address) {
        RetryPolicy retryPolicy = new RetryNTimes(3, 5000);
        client = CuratorFrameworkFactory.newClient(address, retryPolicy);
        client.start();
    }

    /**
     * 展示当前节点下所有节点信息
     */
    public List<String> listByNode(String nodePath) throws Exception {
        return this.client.getChildren().forPath(nodePath);
    }
}