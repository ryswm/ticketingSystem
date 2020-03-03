#!/bin/sh

#This script runs the tix program (main.py python script) with a text file as user input

loginTests=$(find ./Tests/inputs/login -type f -name "*.tti")
for i in $loginTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

logoutTests=$(find ./Tests/inputs/logout -type f -name "*.tti")
for i in $logoutTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

creditTests=$(find ./Tests/inputs/addCredit -type f -name "*.tti")
for i in $creditTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

createTests=$(find ./Tests/inputs/create -type f -name "*.tti")
for i in $createTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

deleteTests=$(find ./Tests/inputs/delete -type f -name "*.tti")
for i in $deleteTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

buyTests=$(find ./Tests/inputs/buy -type f -name "*.tti")
for i in $buyTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done

sellTests=$(find ./Tests/inputs/sell -type f -name "*.tti")
for i in $sellTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done



refundTests=$(find ./Tests/inputs/refund -type f -name "*.tti")
for i in $refundTests
do
    name="${i##*/}"
    base="${name%.*}"
    acc=$(find ./Tests/inputs -type f -name "$base.tai")
    event=$(find ./Tests/inputs -type f -name "$base.tei")
    transaction="/Tests/outputs/$base.adt"
    python3 main.py $acc $event $transaction < $i > ./Tests/outputs/$base.ato

done




