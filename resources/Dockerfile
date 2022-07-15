#
#
#docker run -it --entrypoint "/bin/bash" ubuntu:20.04 to start container

#Using Ubuntu as base image
FROM ubuntu:latest

MAINTAINER Nick Burns, Steven Ryan Ramos, Zainal Shariff

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
RUN \ 
	apt install mysql-server -y && \
	service mysql start

#Install maven
RUN \
	apt install maven -y

	
#Install git to grab repo
RUN \
	apt install git -y
	
#Pull our project from GitHub 
RUN \ 
	git clone https://github.com/rsteven46/jump-group-project1.git