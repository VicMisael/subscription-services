const kafka=require('./kafka.js')

const consumer=kafka.consumer({ groupId: 'default'})

const consume=async ()=>{
    await consumer.connect()
    await consumer.subscribe({topic:'t.subscription.events',fromBeginning:true})
    await consumer.run({
        eachMessage:({message})=>{
            console.log(`received message: ${message.value}`)
        }
    })

}

module.exports=consume