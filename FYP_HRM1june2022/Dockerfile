FROM ubuntu:latest
RUN apt-get -y update 
RUN apt-get -y install openjdk-8-jdk wget
RUN mkdir /usr/local/tomcat
RUN wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.64/bin/apache-tomcat-9.0.64.tar.gz -O /tmp/tomcat.tar.gz
RUN cd /tmp && tar xvfz tomcat.tar.gz
RUN cp -Rv /tmp/apache-tomcat-9.0.64/* /usr/local/tomcat/
COPY FYP_HRM1june2022/target/FYP-HR.war  /usr/local/tomcat/webapps/FYP-HR.war
EXPOSE 8080
CMD /usr/local/tomcat/bin/catalina.sh run
