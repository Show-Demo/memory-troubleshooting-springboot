package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutOfMemoryDemoController {

    @GetMapping("/out-of-memory")
    public String triggerOutOfMemory() {
        try {
            // 模拟内存溢出：创建一个非常大的数组
            System.out.println("Trying to allocate large array...");
            long[] largeArray = new long[Integer.MAX_VALUE / 10];  // 分配较大的数组
            return "Array allocated successfully!";
        } catch (OutOfMemoryError e) {
            // 捕获内存溢出异常
            System.out.println("OutOfMemoryError caught!");
            return "OutOfMemoryError: " + e.getMessage();
        }
    }
}
