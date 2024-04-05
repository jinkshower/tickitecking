# open jdk 17 버전의 환경을 구성
FROM openjdk:17-alpine

COPY ./build/libs/tickitecking-0.0.1-SNAPSHOT.jar app.jar

# 운영 및 개발에서 사용되는 환경 설정을 분리
ENTRYPOINT ["java", "-jar", "app.jar"]
