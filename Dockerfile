# define base docker image
FROM openjdk:17

LABEL maintainer="zeynapp.account"
ADD target/account-0.0.1-SNAPSHOT.jar account.jar
ENTRYPOINT ["java", "-jar", "account.jar"]



