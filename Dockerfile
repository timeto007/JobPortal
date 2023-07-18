FROM openjdk:8
EXPOSE 8080
ADD target/JobPortal-docker.jar JobPortal-docker.jar
ENTRYPOINT [ "java","-jar","/JobPortal-docker.jar" ]