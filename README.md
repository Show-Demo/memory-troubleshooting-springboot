# memory-troubleshooting-springboot
Java内存问题排查demo

- 内存泄漏：访问 http://localhost:8080/memory-leak 来模拟内存泄漏。

- 内存溢出：访问 http://localhost:8080/out-of-memory 来模拟内存溢出。


```sh
java -Xmx512m -jar target/memory-troubleshooting-springboot-0.0.1-SNAPSHOT.jar
java \
	-Xms1m \
	-Xmx1m \
	-XX:+PrintGC \
	-XX:+HeapDumpOnOutOfMemoryError \
	-XX:HeapDumpPath=./heap.bin \
MemoryLeak

```

