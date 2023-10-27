# kafka-basics

## STEP 1: DOWNLOAD AND EXTRACT THE KAFKA
### Follow the steps ( https://kafka.apache.org/quickstart ) 
<b>Open terminal on kafka stored directry (downloaded) and extract the tar by below commands</b>
<pre>
tar -xzf kafka_2.13-3.6.0.tgz
cd kafka_2.13-3.6.0
</pre>
## STEP 2: START THE KAFKA ENVIRONMENT
### Start the ZooKeeper service
Open new terminal on kafka stored directry and run below commands.
<pre>
	.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
</pre>
### Start the Kafka broker service
Open new terminal on kafka stored directry and run below commands.
<pre>
	.\bin\windows\kafka-server-start.bat .\config\server.properties
</pre>
## STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
<pre>
	.\bin\windows\kafka-topics.bat --create --topic my_topic --bootstrap-server localhost:9092
</pre>
## STEP 4: WRITE SOME EVENTS INTO THE TOPIC
<pre>
	.\bin\windows\kafka-console-producer.bat --topic my_topic --bootstrap-server localhost:9092
	>hello world
	>topic demo
</pre>
## STEP 5:  READ THE EVENTS
<pre>
	.\bin\windows\kafka-console-consumer.bat --topic my-topic --from-beginning --bootstrap-server localhost:9092
	hello world
	topic demo
</pre>	
	 
### Note : 
<p>To working with windows terminal use '\' backward slash <br>
 To work with gitbash terminal use '/' forward slash for directory.
 </p>
