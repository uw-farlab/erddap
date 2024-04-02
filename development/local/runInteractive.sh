#!/bin/bash

REPO_PATH="/home/portal/src/erddap"
SOURCE_IMAGE="erddap-docker"
CONTAINER_NAME="erddap_dev"

docker run \
    --name ${CONTAINER_NAME} \
    -d \
    -v ${REPO_PATH}/src:/app/src \
    -v ${REPO_PATH}/target:/app/target \
    -v ${REPO_PATH}/pom.xml:/app/pom.xml \
    ${SOURCE_IMAGE}
