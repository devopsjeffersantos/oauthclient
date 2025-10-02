FROM azul/zulu-openjdk-alpine:21.0.8-21.44-jre-headless
EXPOSE 8080
COPY target/*.jar oauthclient-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/oauthclient-0.0.1-SNAPSHOT.jar"]
