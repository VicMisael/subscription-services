const { Kafka } = require('kafkajs')


const kafka = new Kafka({
  clientId: 'eventConsumer',
  brokers: ['localhost:9092'],
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