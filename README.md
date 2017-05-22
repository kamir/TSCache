TSCache
=======

TSCache is a temporary time series database. 

Temporary means here, that data is hold in it as long as we want to work with it on a regular base. 

It is not the goal, to build a long-term storage solution because HDFS and HBase already exist. The two systems are used as persistence layer. The long term aspects of time series persistence are out of scope. 

We simply start with a tool which allows us to create time series buckets. A time series bucket can be a sequence file or evene special kind of a Parquet file (using AVRO serialization). The bucket gets filled up with collected data, with simulated time series or finally, with data loaded from operational DBs. 

The purpose of the TSB is to save time. In cases, where some time series data is needed more often, we have to find an efficient way of representing the data. But flexibility in terms of combining multiple of such buckets in a meaningful and consistent way has to be manintained as well.

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



