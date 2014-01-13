#! /bin/bash -f

export jarPath="./build/Example.jar"

if [ -e $jarPath ]
then
   java -cp $jarPath Example.HelloWorld "$@"
else
  echo "Unable to find jar file in path $jarPath"
fi
