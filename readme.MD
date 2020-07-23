[![Build Status](https://travis-ci.com/tyo07/ReminderAPI.svg?branch=master)](https:///travis-ci.com/tyo07/ReminderAPI)
[![Coverage Status](https://coveralls.io/repos/github/tyo07/ReminderAPI/badge.svg?branch=master&service=github)](https://coveralls.io/github/tyo07/ReminderAPI?branch=master)

## Why I create this API?
- I need to create my own API for whatever purpose it is..but I don't have any idea at the moment. So I create an API that would remind me certain activities during the day.
- I want to learn Springboot, Docker, AWS, CI/CD all that stuff. So this project will be my pet project


## Current feature
- Unit Test : Yes using JUnit4
- CI/CD : Yes using Travis and Coveralls for code coverage 
- AWS : I am deploying this application to AWS
- Docker : Partially..later I want to deploy in AWS by using docker. Right now, we are still uploading jar file.
- Using MySQL for quick learning purpose. You can run the MySQL docker.

## What I want to add in the future
- Integration Test
- Using profile when deploy to stg/pro
- Integrate with Slack
- Integrate with another API which use different stack (I want to learn Cassandra also)

## Dockerfile
``` 
cd docker
docker build -t sactio1811/mysql:reminder-api .
docker run --name mysql-reminder-api -p 3306:3306 -e MYSQL_DATABASE=activity_api -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=pass -d sactio1811/mysql:reminder-api --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

if you stopped the container and want to start again
docker start mysql-reminder-api
```

# Performance Test

```
change the path of the http target
mvn -Pgatling gatling:test

```