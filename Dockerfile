# 使用 Ubuntu 作为基础镜像
FROM ubuntu:22.04

# 安装 JDK 17
RUN apt update && \
    apt install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

# 设置工作目录
WORKDIR /app

# 将 JAR 包复制到容器中
COPY target/oom-example-1.0-SNAPSHOT.jar /app/oom-example.jar
COPY src/main/resources/logback.xml /app/logback.xml

# 设置环境变量（可选）

# 暴露端口（如果需要）
EXPOSE 8080

# 运行 JAR 文件
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/oom-example.jar"]