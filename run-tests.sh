#!/bin/bash
#include <unistd.h>


numF=$(find ./Tests/inputs -type f -name "*.txt" | wc -l)
((numTests = numF/2))

for i in numTests
do
    
done