#!/bin/sh

#
#Modify History:
#Date           Author             Content & Description
#----------     ----------------   -------------------------------------
#2013.10.15     Leo Cai            初始版本，用来发布后台和前台8181
#

source=/data/projects/source/web/target/o2o-1.0.0.war
target=/data/projects/o2o-8181
backup=/data/projects/backup/o2o-8181[`date "+%Y%m%d%H%M%S"`]

echo '[DEPLOY] Installing o2o-8181...'
echo '[DEPLOY] FROM...' $source
echo '[DEPLOY] TO  ...' $target
echo '[DEPLOY] BACKUP.' $backup

if [ -e "$source" ]; then
    if [ -e "$target" ]; then
        mv $target $backup
            mkdir $target
        else
            mkdir $target
    fi
        unzip -q $source -d $target
        cp /data/projects/config/o2o/base.properties $target/WEB-INF/classes/base.properties
        cp /data/projects/config/o2o/config.properties $target/WEB-INF/classes/config.properties
        cp /data/projects/config/o2o/jdbc.properties $target/WEB-INF/classes/jdbc.properties
        cp /data/projects/config/o2o/log4j.properties $target/WEB-INF/classes/log4j.properties
        chmod 755 /data/projects/o2o-8181
        chmod 755 -R /data/projects/o2o-8181/css
        chmod 755 -R /data/projects/o2o-8181/js
        chmod 755 -R /data/projects/o2o-8181/img
        chmod 755 -R /data/projects/o2o-8181/kindeditor4
         #chmod 644 /data/projects/o2o-8181/css/*


else
    echo "file not exists " $source
fi
#echo '[COMPRESS] js...'
#/home/dyninfo/shoppingmall/bin/compress-js.sh $target/resources/scripts/admin
#echo '[COMPRESS] css...'
#/home/dyninfo/shoppingmall/bin/compress-css.sh $target/resources
echo '[DEPLOY] o2o-8181... [SUCCESS]'


