#!/bin/sh

#This script runs the tix program (main.py python script) with a text file as user input

tests=$(find ./Tests/inputs -type f -name "*.tti")

for i in $tests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done




