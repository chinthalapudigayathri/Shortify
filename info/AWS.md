1. Got to AWS console -> EC2 -> Launch instance
2. give name shortify-backend , AMI: Amanzon index 2023, instance type: t2:micro , key pair: create key pair -> create and download
3. In network settings http,https and tcp select 0 and ssh sleect my ip and save
4. Execute the following command in git bash ssh -i /c/Users/Gayathri/Downloads/createanddownload.pem ec2-user@54.210.123.45
5. Execute the following commands : sudo yum update -y
   sudo yum install java-17-amazon-corretto -y
   sudo yum install git -y
6. Verify by checking java version: java -version
7. Now clone git repository git clone https://github.com/chinthalapudigayathri/Shortify.git
8. cd Shortify
9. build spring boot jar : mvn clean package
10. Run Springboot app java -jar target/*.jar
11. Access this in browser: http://18.61.231.203:8080/api/v1/url/shorten
12. Run springboot in background nohup java -jar target/*.jar > app.log 2>&1 &
13. To connect angular and springboot add this in environment.ts
14. Rebuild angular ng build --configuration production


