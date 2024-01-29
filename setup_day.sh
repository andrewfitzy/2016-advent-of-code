#!/bin/bash

# Ask for the day
read -p 'Challenge Day: ' day

echo Initialising solution and test folder for day $day

# Copy the three directories and rename to contain the day
cp -R ./app/src/main/kotlin/io/github/andrewfitzy/dayxx ./app/src/main/kotlin/io/github/andrewfitzy/day$day
cp -R ./app/src/test/kotlin/io/github/andrewfitzy/dayxx ./app/src/test/kotlin/io/github/andrewfitzy/day$day
cp -R ./app/src/test/resources/dayxx ./app/src/test/resources/day$day

# Then we'll replace xx in the src and test files with the day number
sed -i '' "s/xx/$day/g" ./app/src/main/kotlin/io/github/andrewfitzy/day$day/Task01.kt
sed -i '' "s/xx/$day/g" ./app/src/main/kotlin/io/github/andrewfitzy/day$day/Task02.kt
sed -i '' "s/xx/$day/g" ./app/src/test/kotlin/io/github/andrewfitzy/day$day/TestTask01.kt
sed -i '' "s/xx/$day/g" ./app/src/test/kotlin/io/github/andrewfitzy/day$day/TestTask02.kt


