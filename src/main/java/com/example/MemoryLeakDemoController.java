package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemoryLeakDemoController {

    private List<Object> leakList = new ArrayList<>();

    @GetMapping("/memory-leak")
    public String triggerMemoryLeak() {
        // 模拟快速内存泄漏：循环快速添加对象到列表中
        for (int i = 0; i < 100000; i++) {
            leakList.add(new Object());
            if (i % 1000 == 0) {
                long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                System.out.println("Iteration " + i + " - Current used memory: " + usedMemory / 1024 / 1024 + " MB");
            }
        }
        return "Fast memory leak triggered!";
    }
}
