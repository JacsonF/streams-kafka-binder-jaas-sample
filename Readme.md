#### This project is used to example to authenticate in broker kafka using spring-cloud-stream-binder-kafka-streams and jaas.

At first moment, I followed [this](https://github.com/JacsonF/spring-cloud-stream-samples/tree/main/multi-binder-samples/kafka-multi-binder-jaas) example to create an authentication in my broker kafka, however there are two differences for my project:

I use kafka streams binder, while in the example kafka binder is used.
I only have one broker, while in the example two brokers are used.

When I run the sample i don't need client.jass to authenticate on my broker kafka(I would like that anyone confirm this), only configuration
in my application.properties

So I tried the same aproach for my aplication, but don't work's.

Finally, i foud this aproach that I used im this project, I don't know if this is a good aproach.

I'll use it until I understand better about spring-cloud-stream-binder-kafka-streams

#### Update 23 jun 2021

The [Issue] (https://github.com/spring-cloud/spring-cloud-stream-binder-kafka/issues/1092) was created to work smoothly in version 3.1.4-SNAPSHOT

See the sample example from oficial repo: https://github.com/spring-cloud/spring-cloud-stream-samples/tree/main/kafka-streams-samples/kafka-streams-jaas-security

Discussion:
https://stackoverflow.com/questions/67548283/how-to-use-jaas-configuration-in-spring-cloud-stream-binder-kafka-streams/68092601#68092601

