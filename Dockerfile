# open jdk 17 버전의 환경을 구성
FROM openjdk:17-alpine

# build가 되는 시점에 JAR_FILE이라는 변수 명에 build/libs/*.jar 선언
# build/libs - gradle로 빌드했을 때 jar 파일이 생성되는 경로
ARG JAR_FILE=build/libs/tickitecking-0.0.1-SNAPSHOT.jar

# JAR_FILE을 app.jar로 복사
COPY ${JAR_FILE} app.jar

# application.properties 파일 생성 및 설정값 추가
RUN mkdir -p /app/src/main/resources
RUN touch /app/src/main/resources/application.properties
RUN echo "${APPLICATION_PROPERTIES}" > /app/src/main/resources/application.properties

# 운영 및 개발에서 사용되는 환경 설정을 분리
ENTRYPOINT ["java", "-jar", "app.jar"]
