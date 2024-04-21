#!/usr/bin/env bash

javac *.java

java Main "hw8_1_testcase/tests/0-01.in" > temp.out
diff temp.out "hw8_1_testcase/tests/0-01.out"

for((i=1;i<10;i++)); do
    java Main "hw8_1_testcase/tests/1-0${i}.in" > temp.out
    diff temp.out "hw8_1_testcase/tests/1-0${i}.out"
done

for((i=10;i<=25;i++)); do
    java Main "hw8_1_testcase/tests/1-${i}.in" > temp.out
    diff temp.out "hw8_1_testcase/tests/1-0${i}.out"
done


rm -f *.class
rm -f *.out