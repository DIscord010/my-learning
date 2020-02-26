package club.csiqu.framework.spring.tiny.service.impl;

import club.csiqu.framework.spring.tiny.service.OutputService;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/20 10:04
 */
public class OutputServiceImpl implements OutputService {

    @Override
    public void output(String text) {
        System.out.println(text);
    }
}