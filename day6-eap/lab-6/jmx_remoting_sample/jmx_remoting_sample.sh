#!/bin/sh
BASEDIR=$(dirname $0)
case "`uname`" in
  CYGWIN*) BASEDIR=`cygpath -w "${BASEDIR}"`
           ;;
esac

if [ "x${EAP_HOME}" == "x" ]; then
    echo "Error: Please set environment variable EAP_HOME."
fi
CLASSPATH=${EAP_HOME}/bin/client/jboss-cli-client.jar

jrunscript -cp "$CLASSPATH" -f "${BASEDIR}/jmx_remoting_sample.js" -f -
