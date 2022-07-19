# Report
  - [Introduction](#introduction)
    - [Description](#description)
    - [Deviations](#deviations)
  - [Implementation](#implementation)
    - [DB](#db)
    - [Front](#front)
    - [Microservices](#microservices)
  - [Test & Validation](#test--validation)
    - [Experimental results](#experimental-results)
  - [Conclusion](#conclusion-and-future-implementations)

---

## Introduction
Groups members: Ciammaruconi Daniele; Caparvi Giorgio

Project title: CovidAWS
### Description
Our project’s purpose is to create a cloud application that keeps track about people affected by covid virus. 

We provide a website where a user can see data about people infected and healed by covid virus. An user can also label himself sick or cured with two buttons on the site.

The application relies on the use of Amazon AWS and the following services: 
   - AuroraDB
   - secondo servizio
   - terzo servizio
### Deviations
???

---
## Implementation
Analysing the service to be implemented, we decided to implement the following features: 
   - DB service
   - Counter microservice 
   - Eureka microserver

[schema del servizio]

### DB
As regards the db, we analysed the following entities: users and counters.

In the users query all sick/healed users are recorded (with the relevant times when the operations were performed), in the counter query, on the other hand, the daily total number of sick/healed users is collected every day at 6 p.m., and to optimise the service we will delete all healed users from the users query (as the system does not benefit from keeping records of healed users after counting that they are no longer sick)

[er del db]

### Front


### Microservices
Concerning the microservice, we implemented the microservice with Java Spring Boot.... [scrivere qui anche lo scaling]

## Test & Validation
We wanted to test and verify the efficiency of our application with 3 types of tests (multiple reading of data, multiple writing of data, hybrid read/write) with different amounts of requests (10k, 20k, 30k), for a grand total of 9 tests. These were the results: [foto test, magari con grafi e piccole descrizioni]

### Conclusion and future implementations
The advantages of using cloud technologies such as Docker and Kubernetes are obvious. Especially after having developed and tested all our services locally on our computers; first as simple programmes, then as Docker images and finally in a cluster.
We have seen how it is easier for a developer to work without worrying in detail about the network or scalability in the software logic.

In addition, thanks to Kubernetes and scaling policies, we gained benefits such as self-healing and scalability. because any crashed pod is automatically replaced or replicated.
We achieve high data availability thanks to the AWS platform and the AuroraDB service that hosts our database in the cloud.
In the end, our cloud application works well enough, scales well enough not to drop requests and demonstrates how a simple application can serve thousands of requests simply by using cloud technologies

In the future, we hypothesised that we could improve it by making it a full-fledged monitoring service that can handle requests from the population of a nation or country, thus allowing us to extrapolate anonymous statistical data that will allow us in the future to fight the diseases we encounter in a more targeted manner

Translated with www.DeepL.com/Translator (free version)

