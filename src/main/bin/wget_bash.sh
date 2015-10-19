#!/bin/sh

echo $1
echo $2
echo $3
echo $4

# find /cygdrive/f/fileformats/archiveteam -type d -maxdepth 3 -mindepth 3 -mtime -6

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
timeout 300 wget -a /cygdrive/f/fileformats/archiveteam/wget.log $robots -nd -nH -P $download_dir -r -l 3 -H -A ${2},.zip,.ZIP,.tar.gz,.tar.Z,.tar,.Z,.gz,.lha,.LHA $3


cd $download_dir
for file in *.{zip,ZIP} ; do
    sleep 1
    sync
    echo "unzipping $file"
    mkdir tmp
    mv "${file}" tmp
    cd tmp
    "/cygdrive/c/Program Files/WinRAR/WinRAR.exe" e -o+ -ibck -inul "${file}"
    for extension in ${extensions//,/ } ; do
      echo "looking for extension $extension"
      timeout 60 find . -name "*${extension}" -exec cp -f -p {} ".." ';'
    done
    cd ..
    sleep 1
    sync
    rm -rf tmp
done

cd $download_dir
for file in *.{tar.gz,tar.Z} ; do
    sleep 1
    sync
    echo "unzipping $file"
    mkdir tmp
    mv "${file}" tmp
    cd tmp
    tar -zxvf "${file}"
    for extension in ${extensions//,/ } ; do
      echo "looking for extension $extension"
      timeout 60 find . -name "*${extension}" -exec cp -f -p {} ".." ';'
    done
    cd ..
    sleep 1
    sync
    rm -rf tmp
done

cd $download_dir
for file in *.{tar} ; do
    sleep 1
    sync
    echo "unzipping $file"
    mkdir tmp
    mv "${file}" tmp
    cd tmp
    tar -xvf "${file}"
    for extension in ${extensions//,/ } ; do
      echo "looking for extension $extension"
      timeout 60 find . -name "*${extension}" -exec cp -f -p {} ".." ';'
    done
    cd ..
    sleep 1
    sync
    rm -rf tmp
done

cd $download_dir
for file in *.{Z,gz} ; do
    sleep 1
    sync
    echo "unzipping $file"
    mkdir tmp
    mv "${file}" tmp
    cd tmp
    gunzip "${file}"
    for extension in ${extensions//,/ } ; do
      echo "looking for extension $extension"
      timeout 60 find . -name "*${extension}" -exec cp -f -p {} ".." ';'
    done
    cd ..
    sleep 1
    sync
    rm -rf tmp
done

cd $download_dir
for file in *.{lha,LHA} ; do
    sleep 1
    sync
    echo "unzipping $file"
    mkdir tmp
    mv "${file}" tmp
    cd tmp
    "/cygdrive/c/Program Files/WinRAR/WinRAR.exe" e -o+ -ibck -inul "${file}"
    for extension in ${extensions//,/ } ; do
      echo "looking for extension $extension"
      timeout 60 find . -name "*${extension}" -exec cp -f -p {} ".." ';'
    done
    cd ..
    sleep 1
    sync
    rm -rf tmp
done