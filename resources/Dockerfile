#
#to start container:
#docker run -it --entrypoint "/bin/bash" progresstacker 

#Using Ubuntu as base image
FROM ubuntu:latest

MAINTAINER Nick Burns, Steven Ryan Ramos, Zainal Shariff

ARG CACHEBUST=1

# Install essentials
RUN \
	apt-get update && \
    apt-get install -y build-essential && \
    apt-get install -y software-properties-common && \
    rm -rf /var/lib/apt/lists/*
    
# Install java-11
RUN \
	apt update && \
	apt install openjdk-11-jdk -y

#Install MySQL Server
RUN { \
        echo mysql-community-server mysql-community-server/data-dir select 'root'; \
        echo mysql-community-server mysql-community-server/root-pass password 'root'; \
        echo mysql-community-server mysql-community-server/re-root-pass password 'root'; \
        echo mysql-community-server mysql-community-server/remove-test-db select false; \
    } | debconf-set-selections \
    && apt-get update && apt-get install -y mysql-server 
	

#Install maven
RUN \
	apt install maven -y

	
#Install git to grab repo
RUN \
	apt install git -y
	
#Pull our project from GitHub 
RUN \ 
	git clone https://github.com/rsteven46/jump-group-project1.git
	
CMD \
	service mysql start
	
