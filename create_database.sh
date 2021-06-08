#! /bin/bash

docker run \
	--detach \
	--name=highschooldb \
	--env="MYSQL_ROOT_PASSWORD=highschool2021" \
	--publish 13306:3306 \
	--volume=$PWD/db-data/conf.d:/etc/mysql/conf.d \
	--volume=$PWD/db-data/mysql-data:/var/lib/mysql \
	mysql

sleep 30

docker exec -i highschooldb mysql -u root -phighschool2021 < src/main/resources/instituto.sql

