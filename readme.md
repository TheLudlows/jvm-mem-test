








# 验证流程
1. 构建镜像`docker build -t oom-example:1.0 .`
2. 运行容器设置内存限制为500，
```shell
docker run -d \
--memory=500m --memory-swap=2g \
-e JAVA_OPTS="-XX:+UseContainerSupport -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=80" oom-example:1.0

docker logs -f
```
观察最大内存打印
3. 修改内存限制，`docker docker update --memory 1g  16d1e506474c`,观察日志打印，并无变化
4. 重启进程，查看日志打印，


```shell
$ docker logs -f 09b138f
Mar 13, 2025 3:26:32 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,                      
Mar 13, 2025 3:26:35 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,                      
Mar 13, 2025 3:26:38 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,                      
Mar 13, 2025 3:26:41 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:26:44 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:26:47 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:26:50 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:26:55 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:26:58 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:01 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:04 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:07 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:10 PM org.example.Main printMemoryUsage  # 修改时间点
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:13 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:16 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:19 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:22 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:24 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:27 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:30 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:36 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:44 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 386 MB,
Mar 13, 2025 3:27:53 PM org.example.Main printMemoryUsage # 重启时间点
INFO: Memory Usage - Total: 792 MB,
Mar 13, 2025 3:28:13 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB,
Mar 13, 2025 3:28:16 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB,
Mar 13, 2025 3:28:19 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB,
Mar 13, 2025 3:28:22 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:25 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:28 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:31 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:34 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:37 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 
Mar 13, 2025 3:28:40 PM org.example.Main printMemoryUsage
INFO: Memory Usage - Total: 792 MB, 



```