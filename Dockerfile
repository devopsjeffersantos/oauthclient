FROM azul/zulu-openjdk-alpine:21
EXPOSE 8080
COPY target/*.jar oauthclient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/oauthclient-0.0.1-SNAPSHOT.jar"]
