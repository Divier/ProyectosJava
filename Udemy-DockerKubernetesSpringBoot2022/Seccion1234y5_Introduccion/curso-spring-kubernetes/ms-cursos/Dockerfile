ARG MS_NAME=ms-cursos

FROM openjdk:18-jdk as builder

ARG MS_NAME

WORKDIR /app/$MS_NAME

COPY ./pom.xml /app
COPY ./$MS_NAME/.mvn ./.mvn
COPY ./$MS_NAME/mvnw .
COPY ./$MS_NAME/pom.xml .

#RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw dependency:go-offline

COPY ./$MS_NAME/src ./src

RUN ./mvnw clean package -DskipTests


FROM openjdk:18-alpine

ARG MS_NAME

WORKDIR /app

RUN mkdir ./logs

COPY --from=builder /app/$MS_NAME/target/ms-cursos-0.0.1-SNAPSHOT.jar .

#EXPOSE 8002

ENV PORT 8002
EXPOSE $PORT

#ENTRYPOINT ["java", "-jar", "ms-usuarios-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "ms-cursos-0.0.1-SNAPSHOT.jar"]