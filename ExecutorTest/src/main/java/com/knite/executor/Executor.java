package com.knite.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 模拟多线程爬虫
 * @author Night Kid
 * @date 2017/8/13 19:20
 * @version V1.0
 */
public class Executor {

    private static Integer pages = 1; // 网页数

    private static boolean exeFlag = true; // 执行标识

    public void execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (exeFlag) {
            if (pages <= 100) {
                executorService.execute(new Runnable() {
                    public void run() {
                        System.out.println("爬取了第"+pages+"网页...");
                        pages++;
                    }
                });
            } else {
                if (((ThreadPoolExecutor) executorService).getActiveCount() == 0) { // 活动线程数为0
                    executorService.shutdown(); // 结束所有线程
                    exeFlag = false;
                    System.out.println("爬虫任务已经完成");
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
