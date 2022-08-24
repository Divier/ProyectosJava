ARG MS_NAME=ms-usuarios

FROM openjdk:18-jdk as builder

ARG MS_NAME

WORKDIR /app/$MS_NAME

COPY ./pom.xml /app
COPY ./$MS_NAME/.mvn ./.mvn
COPY ./$MS_NAME/mvnw .
COPY ./$MS_NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline   ( Basicamente ambos comandos RUN hacen lo mismo, se debe usar uno u otro, y lo que hacen es escencialmente descargas las despendencias )

COPY ./$MS_NAME/src ./src

RUN ./mvnw clean package -DskipTests


FROM openjdk:18-alpine

ARG MS_NAME

WORKDIR /app

RUN mkdir ./logs

COPY --from=builder /app/$MS_NAME/target/ms-usuarios-0.0.1-SNAPSHOT.jar .

#EXPOSE 8001

ENV PORT 8001
EXPOSE $PORT

#ENTRYPOINT ["java", "-jar", "ms-usuarios-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "ms-usuarios-0.0.1-SNAPSHOT.jar"]