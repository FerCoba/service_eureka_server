FROM openjdk:8
VOLUME /tmp
EXPOSE 8761
ADD ./target/service_eureka_server-0.0.1-SNAPSHOT.jar service_eureka_server.jar
ENTRYPOINT ["java","-jar","/service_eureka_server.jar"] 