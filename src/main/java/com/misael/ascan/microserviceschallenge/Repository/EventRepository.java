package com.misael.ascan.microserviceschallenge.Repository;

import com.misael.ascan.microserviceschallenge.model.event.Event;

interface EventRepository {

    public void addNewEvent(Event event);

}
