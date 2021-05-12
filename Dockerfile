FROM java:8
WORKDIR /
ADD rent-information-service.jar rent-information-service.jar
CMD ["java","-jar","rent-information-service.jar"]