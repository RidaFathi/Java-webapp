dxa-web-application-java
===
SDL Digital Experience Accelerator Java Spring MVC web application


About
-----
The SDL Digital Experience Accelerator (formerly known as the SDL Tridion Reference Implementation) is a reference implementation of SDL Tridion intended to help you create, design and publish an SDL Tridion-based Web site quickly.

You can find more details and a download of the entire release on https://community.sdl.com/developers/tridion_developer/m/mediagallery/852


Support
---------------
The SDL Digital Experience Accelerator is intended as a toolkit to help the SDL Tridion community and is not an officially supported SDL Tridion product.

If you encounter problems, reach out to the community: http://tridion.stackexchange.com/


Sources
-------

In the `develop` branch you can find our unstable progress, once we have a stable build we will merge that into the `master` branch.


Documentation
-------------

### Prerequisites

#### For building

To build this project, you will need to have the following software installed:

* http://www.oracle.com/technetwork/java/javase/downloads/index.html[Oracle JDK 7]
* https://maven.apache.org/[Apache Maven 3.x]

After installing the JDK and unzipping Maven in a directory of your choice, set the following two environment variables:

* `JAVA_HOME` - Make this point to your JDK installation directory
* `M2_HOME` - Make this point to your Maven installation directory

Include `%JAVA_HOME%\bin` and `%M2_HOME%\bin` in your `PATH`.

#### For running

To run the web application, you will need to have the following software installed:

* http://tomcat.apache.org/[Apache Tomcat 8.x]

*NOTE: There is no need to install Tomcat as a service; it's easier to download and extract the zip version. If you
unzip it into your "Program Files" folder, you will have permissions issues with writing log files, so it's better to
install it somewhere else outside your "Program Files" folder.*

### Building the project

Before building the project, follow these steps (you only need to do this once, not every time you want to build the
project):

. Install the Tridion libraries and third-party libraries into you local Maven repository by following the instructions
    in the README in the directory `tridion-libs`.
. Build and install the DD4T project into you local Maven repository.

Build the project with Maven:

    mvn clean package

If you want to use Contextual Image Delivery in the example webapp, edit the file `webapp-main\src\main\resources\cd_ambient_conf.xml` and
compile the project with the profile `cid` enabled:

    mvn clean package -P cid

(see the README in the module `cid-module` for more information).

If no errors occur, you will find the resulting file `example-webapp.war` in the directory `example-webapp\target`.

### Running the project

To deploy the project in Tomcat, you'll need to do a number of things.

. Unpack the `example-webapp.war` file in a subdirectory of Tomcat's `webapps` directory. If you want to deploy the web
application into the root context, the name of the subdirectory must be `ROOT`. 
. Add a `cd_licenses.xml` with valid Tridion licenses to the directory `%TOMCAT_HOME%\webapps\<webappdir>\WEB-INF\classes`.
. Edit the configuration files in `%TOMCAT_HOME%\webapps\<webappdir>\WEB-INF\classes` (see below).
. Start Tomcat by executing `%TOMCAT_HOME%\bin\startup.bat`.
. Use your browser to access the web application.

*NOTE: The example Tridion content contains CSS and JavaScript files that assume that the web application is deployed
into the root context, so if you are using this example content, then you must deploy the web application in the
directory `%TOMCAT_HOME%\webapps\ROOT`.*

#### Configuration

The directory `%TOMCAT_HOME%\webapps\<webappdir>\WEB-INF\classes` contains a number of XML configuration files. You
will need to edit at least the following files:

* `cd_storage_conf.xml` - Database settings. These settings must point to a Tridion broker database in which the content
that the web application should use is deployed.
* `cd_dynamic_conf.xml` - Settings for Tridion dynamic content. This information is necessary to map URLs to Tridion
publications.
* `cwd_engine_conf.xml` - The Tridion Contextual Web Delivery engine configuration. This is used when you use
Contextual Image Delivery (CID) for serving images.

*NOTE: Contextual Image Delivery (CID) is an optional component. For using Contextual Image Delivery, you need an
additional license. Contact SDL if you with to use CID and you do not have such a license (or if you are not sure).*


Repositories
------------

The following repositories with source code are available:

 - https://github.com/sdl/dxa-content-management - Core Template Building Blocks
 - https://github.com/sdl/dxa-html-design - Whitelabel HTML Design
 - https://github.com/sdl/dxa-modules - Modules
 - https://github.com/sdl/dxa-web-application-dotnet - .NET MVC web application
 - https://github.com/sdl/dxa-web-application-java - Java Spring MVC web application


Branching model
---------------

We intend to follow Gitflow (http://nvie.com/posts/a-successful-git-branching-model/) with the following main branches:

 - master - Stable 
 - develop - Unstable
 - release/x.y - Release version x.y

Please submit your pull requests on develop. In the near future we intend to push our changes to develop and master from our internal repositories, so you can follow our development process.


License
-------
Copyright (c) 2014-2015 SDL Group.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
