### Can run mysql locally if not setup using docker containers:
```
 docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customerdb -p 3306:3306 -d mysql:8
```

### Modify the pom.xml and application.properties dependency from the original code to configure for Azure

### Customize the CorsConfig.java to allow the deployed React application to access the server. 