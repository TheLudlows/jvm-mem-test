package org.example;
import java.util.logging.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {

        while(true)
        {
            Thread.sleep(3000);
            Runtime runtime = Runtime.getRuntime();

            printMemoryUsage(runtime);
        }
    }

    private static void printMemoryUsage(Runtime runtime) {
        long totalMemory = runtime.maxMemory(); // 当前JVM总内存
        long freeMemory = runtime.freeMemory();   // 当前JVM空闲内存
        long usedMemory = totalMemory - freeMemory; // 已使用内存
        logger.info("Memory Usage - Total: " + bytesToMegabytes(totalMemory) + " MB, ");
    }

    private static long bytesToMegabytes(long bytes) {
        return bytes / (1024 * 1024);
    }
}