const { Kafka } = require('kafkajs')

const KAFKA_BROKER=process.env.KAFKA_BROKER;

const kafka = new Kafka({
  clientId: 'eventConsumer',
  brokers: [KAFKA_BROKER==null?"127.0.0.1:9092":KAFKA_BROKER],
})

const producer = kafka.producer()
produce = async ()=>{
await producer.connect()
await producer.send({
  topic: 'test-topic',
  messages: [
    { value: 'Hello KafkaJS user!' },
  ],
})

}

produce()
module.exports = kafka