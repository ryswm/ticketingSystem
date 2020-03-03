#!/bin/bash

#This script runs the tix program (main.py python script) with a text file as user input

if [ "$1" == "" ]; then
    echo "No account file defined"
    exit 1
fi

if [ "$2" == "" ]; then
    echo "No Event file defined"
    exit 2
fi

numLoginTests=$(find ./Tests/inputs/login/ -type f -name "*.tti" | wc -l)
loginTests=$(find ./Tests/inputs/login/ -type f -name "*.tti")

tests=$(find /Tests/inputs -type f -name "*.tti")

for i in $tests
do
    python3 main.py $1 $2 < $i
done
x="./Tests/inputs/login3.tti"



