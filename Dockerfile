From openjdk:8
EXPOSE 8080
ADD target/InsuranceService2-0.0.1-SNAPSHOT.war  InsuranceService2-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/InsuranceService2-0.0.1-SNAPSHOT.war" ]
