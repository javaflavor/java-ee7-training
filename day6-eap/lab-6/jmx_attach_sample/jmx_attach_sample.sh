#!/bin/sh
BASEDIR=$(dirname $0)
case "`uname`" in
  CYGWIN*) BASEDIR=`cygpath -w "${BASEDIR}"`
           ;;
esac

if [ "x${EAP_HOME}" == "x" ]; then
    echo "Error: Please set environment variable EAP_HOME."
elif [ $# -lt 1 ]; then
    echo "Usage: `basename $0` <pid>"
else
PID=$1

jrunscript -f "${BASEDIR}/jmx_attach_sample.js" -f - ${PID}

fi
