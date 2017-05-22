TSCache
=======

TSCache is a temporary time series database. 

It is not the goal, to build a long-term storage solution because HDFS and HBase already exist. The two systems are used as persistence layer. 

Managing the time series metadata and transformation of time series data in multiple formats from multiple source systems into each other is the focus of this software library.

Features
========
This project provides a web-interface for time series and time series bucket manipulation for time series data stored in HBase.

Some time series analysis algorithms are already includes, others can be added as plugins.

Architecture
============
The web-application runs locally in a Jetty server.

The autoingest functionality is implemented as an Apache Flink application. 
The flink application can be started via Docker, assuming a Dockerized Flink cluster is available. 

Apache HBase runs in a Docker container.

Apache Flink runs in a Docker container.



