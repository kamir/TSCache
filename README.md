TSCache
=======

This project provides a web-interface for time series and time series bucket manipulation for time series data stored in HBase.

The web-application runs locally in a Jetty server.

The autoingest functionality is implemented as an Apache Flink application. 
The flink application can be started via Docker, assuming a Dockerized Flink cluster is available. 

Apache HBase runs in a Docker container.

Apache Flink runs in a Docker container.



