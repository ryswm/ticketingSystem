#!/bin/sh

#Checking difference between expected and actual terminal output
testout=$(find ./Tests/expected -type f -name "*.eto")  #Find all expected terminal output files
for i in $testout
do
    name="${i##*/}"     #Get filename from path
    base="${name%.*}"   #Get test name from filename
    actual=$(find ./Tests/outputs -type f -name "$base.ato")    #Find corresponding actual terminal output file
    expected=$(find ./Tests/expected -type f -name "$base.eto") #Find corresponding expected terminal output file
    difference=$(diff $actual $expected)    #Check difference

    if [ "$difference" != "" ]  #If there is a difference
    then
        echo $difference > ./Tests/results/$base.resterm    #Write difference to result file
    else
        echo "Test $base terminal output passed"    #Else, print test passed
    fi
done

#Checking difference between expected and actual transaction file output
testtran=$(find ./Tests/expected -type f -name "*.edt") #Find all expected transaction output files
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

