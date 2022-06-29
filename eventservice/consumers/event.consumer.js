const kafka=require('./kafka.js')
const Event = require('../models/event.model')

const consumer=kafka.consumer({ groupId: 'default'})

// userId:{type: Number,required: true},
// userName:{type: String,required: true},
// state:{type: String,required:true},
// alterDate:{type:String,required:true}

const consume=async ()=>{
    await consumer.connect()
    await consumer.subscribe({topic:'t.subscription.events',fromBeginning:true})
    await consumer.run({
        eachMessage:({message})=>{
            console.log(`received message: ${message.value}`)
            const obj=JSON.parse(message.value);
            //console.log(`received message: ${JSON.parse(message.value)}`)
            Event.create({userId:obj.userId,userName:obj.userName,state:obj.state,alterDate:obj.alterDate})
        }
    })

}

module.exports=consume