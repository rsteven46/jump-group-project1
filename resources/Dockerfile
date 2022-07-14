#
#
#

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
	systemctl start mysql.service

#Install maven
RUN \
	apt install maven -y

