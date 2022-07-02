const httpProxy = require('express-http-proxy');
const express = require('express');
const app = express();
var logger = require('morgan');
 
app.use(logger('dev'));
 
const EVENTSERVICE_ADDRESS=process.env.EVENTSERVICE_ADDRESS
const SUBSCRIPTIONSERVICE_ADDRESS=process.env.SUBSCRIPTIONSERVICE_ADDRESS
function selectProxyHost(req) {
    if (req.path.startsWith('/eventservice')){
        console.log(EVENTSERVICE_ADDRESS)
        return EVENTSERVICE_ADDRESS;}
    else if (req.path.startsWith('/subscriptionservice')){
        console.log(SUBSCRIPTIONSERVICE_ADDRESS)
        return SUBSCRIPTIONSERVICE_ADDRESS;
    }
}
 
app.use((req, res, next) => {
    httpProxy(selectProxyHost(req))(req, res, next);
});
 
app.listen(3050, () => {
    console.log('API Gateway running!');
});