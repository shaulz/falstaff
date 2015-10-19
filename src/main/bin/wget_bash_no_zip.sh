#!/bin/sh

echo $1
echo $2
echo $3
echo $4

robots="-e robots=off "
if [ "$4" == "robots" ]
then
  robots=""
fi
echo "$robots"
download_dir="${1}"
echo "download_dir $download_dir"
extensions="${2}"
for extension in ${extensions//,/ } 
  do echo "extension $extension"
done 
timeout 900 wget -a /cygdrive/f/fileformats/archiveteam/wget.log $robots -nc -nd -nH -P "$download_dir" -r -l 3 -H -A ${2} "$3"


