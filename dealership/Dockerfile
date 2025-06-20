FROM eclipse-temurin:23-jre

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="0.0.1-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:simple-rpg-user
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV RPG_CHARACTER_URL=http://localhost:8081

EXPOSE 8080

COPY target/simple-rpg-user-${VERSION}.jar /opt/simple-rpg-user/simple-rpg-user.jar

CMD ["java", "-jar", "/opt/simple-rpg-user/simple-rpg-user.jar"]
