Fog Computing based CEP Engine
==================

This engine written using Esper CEP engine make use of Fog computing and also Cloud computing via a gateway event scheduling mechanism according to event priorities.


requirements
============

Maven
To simulate the sensor data file required (datalog1.txt provided)
A linux OS with "ifstat" and "uptime" tools installed
To simulate the Cloud CEP engine a seperate server is required.


setup
=====


Step 1: 'mvn clean install' (this will compile and build the project)

Step 2: 'mvn exec:java' (this will start running the demo - sending random temperature events)

Step 3: if the application is on a local node, input "n" when asked, if its in the cloud input "y"

Step 4: input the number of CPU cores system has


	
