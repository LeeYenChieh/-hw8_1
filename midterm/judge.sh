#!/usr/bin/env bash

javac *.java

for((i=1;i<10;i++)); do
    echo "${i}"
    java LibrarySystem "testcase/tests/0-0${i}.in" > temp.out
    diff temp.out "testcase/tests/0-0${i}.out"
    echo ""
    echo ""
done

for((i=10;i<=28;i++)); do
    echo "${i}"
    java LibrarySystem "testcase/tests/0-${i}.in" > temp.out
    diff temp.out "testcase/tests/0-${i}.out"
    echo ""
    echo ""
done


rm -f *.class
rm -f *.out