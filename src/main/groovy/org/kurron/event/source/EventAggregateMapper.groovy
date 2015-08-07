package org.kurron.event.source

/**
 * Knows how to manage the mapping of a stream of events to arrive at a particular aggregate.
 */
class EventAggregateMapper {

    UserAggregate processEvent( UserCreateEvent event ) {
        // add the event to the list of seen events
        // order the list
        // run through the events and generate the aggregate
    }
    UserAggregate processEvent( UserUpdateEvent event ) {
        // add the event to the list of seen events
        // order the list
        // run through the events and generate the aggregate
    }
    UserAggregate processEvent( UserDeleteEvent event ) {
        // add the event to the list of seen events
        // order the list
        // run through the events and generate the aggregate
    }
}
