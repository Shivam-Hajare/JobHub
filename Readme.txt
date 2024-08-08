To create docker image:
mvnw.cmd spring-boot:build-image -Dspring-boot.build-image.imageName=shivam123456789/jobhub

Now to run this image:
docker run -p 8080:8080 shivam123456789/jobhub



docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=JobHub -e MYSQL_USER=root -e MYSQL_PASSWORD=root -p 3307:3306 -d mysql:8.3.0

testing CICD
test1
