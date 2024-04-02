# Local interactive maven environment

If you are on a slow internet connection, the build
process can be quite slow when downloading large
remote assets.

This container also has a vi editor and less installed.

This container allows you to run the compile step manually
to allow you to debug any issues.

NOTE: This does not copy the `src` directory or the
build file for maven (`pom.xml`).  These must be
specified when you run the container the first time.

If you modify the `pom.xml` file, do so within the
container.  If you edit this file outside the container
when it is running, the container will not see the
changes.

By mounting the directory and file into the container, any
changes will be ready for git to commit.

```
$ git clone git@github.com:ERDDAP/erddap.git
$ cd erddap
```

## Download assets

```
$ cd development/local
$ ./getLargeDownloads.sh
```

## Build, run and interact

Return to the repository root and try to build the image:
```
$ cd erddap
$ docker build -f development/local/Dockerfile -t erddap-docker .
```

If the image builds, you can now run the container.
```
$ export REPO_PATH=`pwd`
$ docker run --name erddap_dev -d -v ${REPO_PATH}/src:/app/src -v ${REPO_PATH}/pom.xml:/app/pom.xml erddap-docker
```

Once the container is running, you can login and interact with it and try to compile:
```
$ docker exec -it erddap_dev bash
# mvn -f pom.xml package
```
