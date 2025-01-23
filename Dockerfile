FROM openjdk:23
ADD target/pos.jar pos.jar
ENTRYPOINT ["java","-jar","pos.jar"]