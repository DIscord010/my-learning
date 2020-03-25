package club.csiqu.learn.basis.jvm.instrument;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/16 16:01
 */
public class Attacher {

    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("13544");
        // 此处相对路径由传入的 JVM决定，即如使用相对路径是由传入的 JVM环境的路径决定，而不是当前主函数决定
        vm.loadAgent("src/main/resources/agent/agent.jar");
    }

}