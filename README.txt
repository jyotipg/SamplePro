STEPS :-- run below commands step by step

1. :-  go to the terminal (where is your java code ) 
2. :-  then run  command :::::  ( mvn clean install)
3. :-  then go to target folder and  rename (externalLogger-0.0.1-SNAPSHOT.jar) as app.jar 
4. :-  copy app.jar in  "test-jar" folder.
5. :-  now go to the terminal from "test-jar" folder
==============================================================================================================

EXECUTION PROCESS :-

if you want to create log with default location then run below command
java -jar app.jar 


if you want to create log in different location then run below command  (ON WINDOWS)

java -jar app.jar logPath=c:/log/Application-dynamic-logs.log

=============================================================================================================

if you want to create log in different location then run below command  (ON LINUX)


java -jar app.jar logPath=/home/swami/WORK/SCHEDULE/externalLogger/test-jar/Application-dynamic-logs.log

=============================================================================================================
