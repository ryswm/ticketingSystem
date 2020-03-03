#!/bin/bash
#include <unistd.h>


numF=$(find ./Tests/inputs -type f -name "*.tti")
for i in $numF; do
    echo $i
done
