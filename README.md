montecarlo-ps
=============

[![Build Status](https://travis-ci.com/agjacome/montecarlo-ps.svg?branch=master)](https://travis-ci.com/agjacome/montecarlo-ps)
[![Heroku Status](https://heroku-badge.herokuapp.com/?app=montecarlo-ps)](http://montecarlo-ps.herokuapp.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![No Maintenance Intended](http://unmaintained.tech/badge.svg)](http://unmaintained.tech/)

Side project in very early stages. Its purpose is to provide a web interface
over a simple task estimation algorithm based upon Montecarlo simulations and
historical JIRA data.

Current production website can be accessed through [montecarlo-ps in
Heroku](http://montecarlo-ps.herokuapp.com).

#### How to run and develop locally

To run the project locally, both [Leiningen](https://leiningen.org/) and a
valid [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
are required.

Given the prerequisites are met, just launch the following command in the root
of the project:

    $ lein run

This will start a local server with the current version of the application,
accessible through http://localhost:8080.

To run all the tests, the following command must be executed:

    $ lein test


#### Contributors

* Alberto G. Jácome - https://github.com/agjacome
* Susan Henríquez - https://github.com/susanhenriquezph
* Tom Page - https://github.com/twp88
