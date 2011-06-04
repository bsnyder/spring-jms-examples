Spring JMS Examples 
===================

This project provides some examples of using Spring JMS for both asynchronous
and synchronous message consumption. 

Asynchronous Consumption
------------------------
All of the examples for asynchronous message consumption utilize the Spring
[DefaultMessageListenerContainer](http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jms/listener/DefaultMessageListenerContainer.html) for message consumption. 

Spring JMS supports three types of message listeners including: 
* [javax.jms.MessageListener](http://download.oracle.com/javaee/5/api/javax/jms/MessageListener.html)
* [SessionAwareMessageListener](http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jms/listener/SessionAwareMessageListener.html)
* [MessageListenerAdapter](http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jms/listener/adapter/MessageListenerAdapter.html

These three types of message listeners are all demonstrated using examples in
the async directory. 

### Running the Examples ###
These examples are intended to be run from the command-line using Maven. The
consumer should be run in one terminal and the producer should be run in a
separate terminal. Below are examples of running each of the three
asynchronous examples. 

#### Run the Producer for the `MessageListener` Example ####

    $ cd ./async/message-listener
    $ mvn -Pproducer exec:java

#### Run the Consumer for the `MessageListener` Example ####

    $ cd ./async/message-listener
    $ mvn -Pconsumer exec:java

#### Run the Producer for the `SessionAwareMessageListener` Example ####

    $ cd ./async/message-listener
    $ mvn -Pproducer exec:java

#### Run the Consumer for the `SessionAwareMessageListener` Example ####

    $ cd ./async/message-listener
    $ mvn -Pconsumer exec:java

#### Run the Producer for the `MessageListenerAdapter` Example ####
This example requires a couple of arguments, the first one for the
destination name and the second one for the message type. The destination name
should be either FOO.TEST or FOO.TEST2. The message type should text, bytes,
map or object. Below is an example of text: 

    $ cd ./async/message-listener
    $ mvn -Pproducer exec:java -Dexec.args="FOO.TEST2 text"

These arguments allow you to invoke one of two `MessageListenerAdapter`
examples and to send four different types of messages. 

#### Run the Consumer for the `MessageListenerAdapter` Example ####

    $ cd ./async/message-listener
    $ mvn -Pconsumer exec:java


Synchronous Consumption
------------------------
The example for synchronous message consumption uses the Spring
[JmsTemplate](http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jms/core/JmsTemplate.html).

### Running the Examples ###
This example is also intended to be run from the command-line using Maven. The
consumer should be run in one terminal and the producer should be run in a 
separate terminal. Below is an example of running the synchronous example. 

#### Run the Consumer for the `JmsTemplate` Example ####

    $ cd ./sync/jms-template
    $ mvn -Pconsumer exec:java 

#### Run the Producer for the `JmsTemplate` Example ####
This example supports two different types of sends including a simple
convertAndSend and also a jmsSend. These two types are specified using an
argument when starting up the producer as shown below: 

    $ cd ./sync/jms-template
    $ mvn -Pproducer exec:java -DsendType=converAndSend

Summary
-------
If you have any questions about these examples, please create an issue for the
project. This will allow everyone to see all questions and answers and it will
notify me when folks enter new issues. 

I also blog about JMS occasionally. Here are some popular posts I have
written about Spring JMS: 

* [Using Spring to Send JMS Messages](http://bsnyderblog.blogspot.com/2010/02/using-spring-jmstemplate-to-send-jms.html)
* [Using Spring to Receive JMS Messages](http://bsnyderblog.blogspot.com/2010/02/using-spring-to-receive-jms-messages.html)
* [Tuning JMS Message Consumption In Spring](http://bsnyderblog.blogspot.com/2010/05/tuning-jms-message-consumption-in.html)

