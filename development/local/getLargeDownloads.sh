#!/bin/bash

TARGET_DIR="download_cache"

if [ ! -d ${TARGET_DIR} ]; then
    mkdir ${TARGET_DIR}
fi

ERDDAP_VER="v2.23"
ERDDAP_REF_VER="1.0.0"
NETCDF_VER="5.5.3"

DFILE="netcdfAll-${NETCDF_VER}.jar"
SURL="https://downloads.unidata.ucar.edu/netcdf-java/${NETCDF_VER}/${DFILE}"

if [ ! -f ${TARGET_DIR}/${DFILE} ]; then
    curl -sfSL "$SURL" -o ${TARGET_DIR}/${DFILE}
fi

DFILE="erddapContent.zip"
SURL="https://github.com/ERDDAP/erddap/releases/download/${ERDDAP_VER}/${DFILE}"

if [ ! -f ${TARGET_DIR}/${DFILE} ]; then
    curl -sfSL "$SURL" -o ${TARGET_DIR}/${DFILE}
fi

DFILE="etopo1_ice_g_i2.zip"
SURL="https://github.com/ERDDAP/ERDDAPRefFiles/releases/download/${ERDDAP_REF_VER}/${DFILE}"

if [ ! -f ${TARGET_DIR}/${DFILE} ]; then
    curl -sfSL "$SURL" -o ${TARGET_DIR}/${DFILE}
fi

DFILE="ref_files.zip"
SURL="https://github.com/ERDDAP/ERDDAPRefFiles/releases/download/${ERDDAP_REF_VER}/${DFILE}"

if [ ! -f ${TARGET_DIR}/${DFILE} ]; then
    curl -sfSL "$SURL" -o ${TARGET_DIR}/${DFILE}
fi

