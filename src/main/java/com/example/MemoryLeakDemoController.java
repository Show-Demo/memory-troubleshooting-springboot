package com.example.memorydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemoryLeakDemoController {

    private List<Object> leakList = new ArrayList<>();

    @GetMapping("/memory-leak")
    public String triggerMemoryLeak() {
        // 模拟内存泄漏：不断添加对象到列表
        // 每隔一段时间会打印当前的堆内存使用情况
        for (int i = 0; i < 10000; i++) {
            leakList.add(new Object());
            if (i % 1000 == 0) {
                // 每 1000 次循环，打印当前堆内存使用情况
                long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                System.out.println("Current used memory: " + usedMemory / 1024 / 1024 + " MB");
            }
            try {
                Thread.sleep(100); // 延时100ms，模拟真实使用场景
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Memory leak triggered!";
    }
}
