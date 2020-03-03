#!/bin/sh

testout=$(find ./Tests/expected -type f -name "*.eto")
for i in $testout
do
    name="${i##*/}"
    base="${name%.*}"
    actual=$(find ./Tests/outputs -type f -name "$base.ato")
    expected=$(find ./Tests/expected -type f -name "$base.eto")
    difference=$(diff $actual $expected)

    if [ "$difference" != "" ]
    then
        echo $difference > ./Tests/results/$base.resterm
    else
        echo "Test $base terminal output passed"
    fi
done

testtran=$(find ./Tests/expected -type f -name "*.edt")
for i in $testtran
do
    name="${i##*/}"
    base="${name%.*}"

    actual=$(find ./Tests/outputs -type f -name "$base.adt")
    expected=$(find ./Tests/expected -type f -name "$base.edt")
    
    difference=$(diff $actual $expected)

    if [ "$difference" != "" ]
    then
        echo $difference > ./Tests/results/$base.restran
    else
        echo "Test $base transaction file passed"
    fi
done

