METALNX IRODS TEST CONNECTION BUILD GUIDE
=========================================

This document provides instructions on how to build the Metalnx iRODS Test Connection JAR file.

----------------------------------

Copyright © 2015-16 EMC Corporation.

This software is provided under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).

The information in this file is provided “as is.” EMC Corporation makes no representations or warranties of any kind with respect to the information in this publication, and specifically disclaims implied warranties of merchantability or fitness for a particular purpose. 

-------------------------------- 

## Depedencies
 
Metalnx iRODS Test Connection depends on JAVA 1.8 or higher and Maven 3.1 or higher. Before starting, you should have already installed Maven in your environment. 

Maven is a Apache project available on [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi). This website provides download links and you can also find a Maven overview and how to integrate the tool in your system.  

You can typically install Maven via a package manager like `yum` or `apt-get`. For example:

    yum install maven

## Compilation

	mvn package
	
## JAR file

After running `mvn package`, a `jar` file will created. This `jar` will be used to test the connection to iRODS.

*Metalnx iRODS Test Connection* uses Jargon to connect to iRODS, for more information about it, please check out [Jargon's Github Repository](https://github.com/DICE-UNC/jargon).

## License

Copyright © 2015-16 EMC Corporation.

This software is provided under the Software license provided in the [LICENSE](../LICENSE.md) file.

[irods]: http://www.irods.org
[samtools]: http://www.htslib.org/
[vcf-files]: http://www.1000genomes.org/wiki/Analysis/vcf4.0
