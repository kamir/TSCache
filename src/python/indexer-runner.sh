spark-submit \
--master yarn \
--deploy-mode cluster \
--jars $myDependencyJarFiles \
--executor-memory 500M \
--conf "spark.executor.extraJavaOptions=$myJVMOptions" \
--driver-java-options "$myJVMOptions" \
--class org.apache.solr.crunch.CrunchIndexerTool \
--files $(ls $myResourcesDir/log4j.properties),$(ls $myResourcesDir/test-morphlines/loadSolrLine.conf),tokenFile.txt\
$myDriverJar \
-D hadoop.tmp.dir=/tmp \
-D morphlineVariable.ZK_HOST=$(hostname):2181/solr \
-D tokenFile=tokenFile.txt \
--morphline-file loadSolrLine.conf \
--pipeline-type spark \
--chatty \
--log4j log4j.properties \
/user/systest/input/hello1.txt