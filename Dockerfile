FROM openjdk:17-jdk
EXPOSE 8080
ADD target/jobportal-docker.jar jobportal-docker.jar
ENTRYPOINT [ "java","-jar","/jobportal-docker.jar" ]