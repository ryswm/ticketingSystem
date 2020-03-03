#!/bin/bash

if [ "$1" == "" ]; then
    echo "No account file defined"
    exit 1
fi

if [ "$2" == "" ]; then
    echo "No Event file defined"
    exit 2
fi
x="input.txt"
python3 main.py $1 $2 < $x


