#!/bin/bash
#include <unistd.h>


numF=$(find ./Tests/inputs -type f -name "*.txt" | wc -l)
((numTests = numF/2))
echo $numTests