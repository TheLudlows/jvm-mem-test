docker build -t oom-example:1.0 .


docker run -d \
--memory=500m --memory-swap=2g \
-e JAVA_OPTS="-XX:+UseContainerSupport -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=80" oom-example:1.0


docker logs -f

docker update --memory 1g  16d1e506474c

