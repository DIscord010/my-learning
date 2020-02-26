package club.csiqu.framework.spring.tiny.service.impl;

import club.csiqu.framework.spring.tiny.service.HelloService;
import club.csiqu.framework.spring.tiny.service.OutputService;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 10:04
 */
public class HelloServiceImpl implements HelloService {

    private String text;

    private OutputService outputService;

    @Override
    public void hello() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}