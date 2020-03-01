#!/bin/bash

if [ "$1" == "" ]; then
    echo "No account file defined"
    exit 1
fi

if [ "$2" == "" ]; then
    echo "No Event file defined"
    exit 2
fi

python3 main.py $1 $2
