package com.knite.executor;

import org.junit.Test;

/**
 * @Description 测试模拟多线程爬虫
 * @author Night Kid
 * @date 2017/8/13 19:25
 * @version V1.0
 */
public class ExecutorTest {

    @Test
    public void testExecute() {
        Executor executor = new Executor();
        executor.execute();
    }
}
