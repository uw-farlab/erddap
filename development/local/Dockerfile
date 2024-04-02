# This docker file is currently just meant for local development use.
#
# Usage from project root:
# docker build -f development/local/Dockerfile -t erddap-docker .

# Set up build environment
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Add additional system packages to the base image so the
# user can work within the container.
RUN apt-get update \
    && apt-get install -y less vim-tiny \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir /app/
WORKDIR /app/

# Temp dir required for unit tests.
RUN mkdir /temp/

# Copy in some source files.  For the interactive
# container, the src and pom.xml are linked from
# the local environment to the container at runtime.
ADD download ./download
ADD images ./images
ADD WEB-INF ./WEB-INF
RUN mkdir /app/WEB-INF/lib/
ADD ./development/local/download_cache ./download_cache

# Create a local repository for artifacts not hosted on
# any remote repository.
RUN mkdir /app/repo/
RUN mvn deploy:deploy-file -Durl=file:///app/repo/ -Dfile=download_cache/netcdfAll-5.5.3.jar -DgroupId=edu.ucar -DartifactId=netcdfAll -Dversion=5.5.3 -Dpackaging=jar

# Keep container operating
COPY ./development/local/entrypoint.sh /
ENTRYPOINT ["/entrypoint.sh"]
