
## Kafka Notes :

### Apache Kafka Download Links : 

 Download Page : https://kafka.apache.org/downloads

 Downloaded Version : https://downloads.apache.org/kafka/3.6.1/kafka_2.13-3.6.1.tgz



### 1. Start Zookeeper Server :

	command to start : arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/zookeeper-server-start.sh config/zookeeper.properties

		default port : 2181

### 2. Start kafka server/broker :

	command to start : arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-server-start.sh config/server.properties
	
		default port : 9092
	
### 3. Create topic :
	
	command to create tpoic : arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic myfirst-topic --partitions 3 --replication-factor 1
	
	arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic myfirst-topic --partitions 3 --replication-factor 1
	
	command to list topics : arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --		list
	myfirst-topic
	mysec-topic

	command to describe topic : arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic myfirst-topic
	output :	
					Topic: myfirst-topic	TopicId: LNxlK2mNTVaDQ3y2Z22NRg	PartitionCount: 3	ReplicationFactor: 1	Configs: 
					Topic: myfirst-topic	Partition: 0	Leader: 0	Replicas: 0	Isr: 0
					Topic: myfirst-topic	Partition: 1	Leader: 0	Replicas: 0	Isr: 0
					Topic: myfirst-topic	Partition: 2	Leader: 0	Replicas: 0	Isr: 0


### 4. Offset explorer Tool:
	Link to download :  https://www.kafkatool.com/download.html

	Required java 11 to install & run offset explorer.



### 5. Kafka Console Producer : 
	arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic myfirst-topic
	
	>this is sample msg from producer

	Note : To push bulk messages from csv file > $ bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic myfirst-topic </home/arjunb/Downloads/customers-1000.csv


### 6.Kafka Console producer : 
	arjunb@arjunb-Vostro-3480:~/kafka/kafka_2.13-3.6.1$ bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myfirst-topic --from-beginning

	>this is sample msg from producer



### 7. Confluent Kafka [Community Edition] :

Link to Download : https://www.confluent.io/get-started/?product=self-managed	


7.1 Start Confluent Zookeeper Server :
		
	bin/zookeeper-server-start etc/kafka/zookeeper.properties 

7.2 Start Confluent Kafka Server :

	bin/kafka-server-start etc/kafka/server.properties 

7.3 Create topic :

	bin/kafka-topics --bootstrap-server localhost:9092 --create --topic mythird-topic

7.4 Produce Message :
	
	bin/kafka-console-producer --bootstrap-server localhost:9092 --topic mythird-topic
	>mobile:8796977808 
	>add: shivalaua hsg. soc., sus gaon, pune-411021


7.5 Consume Message :

	bin/kafka-console-consumer --bootstrap-server localhost:9092 --topic mythird-topic --from-beginning
	>mobile:8796977808
	>add: shivalaua hsg. soc., sus gaon, pune-411021
