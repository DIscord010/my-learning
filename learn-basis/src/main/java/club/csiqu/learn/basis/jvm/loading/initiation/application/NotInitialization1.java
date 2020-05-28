package club.csiqu.learn.basis.jvm.loading.initiation.application;

import club.csiqu.learn.basis.jvm.loading.initiation.SuperClass;

/**
 * 被动引用：通过数组定义来引用类，不会触发类的初始化
 *
 * @author chensiqu [540498860@qq.com]
 * @since 2019/9/24 21:24
 */
public class NotInitialization1 {

    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[10];
    }
}