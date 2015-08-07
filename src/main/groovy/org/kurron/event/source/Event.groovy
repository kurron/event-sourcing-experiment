package org.kurron.event.source
/**
 * Base type for all events in the system.
 */
abstract class Event {

    /**
     * Unique identifier for this event instance.
     */
    UUID id

    /**
     * The order that event occurred in the stream.  0 is the first event and Integer.MAX is the most recent event.
     */
    //TODO: are sequences unique through the whole stream or a sub-set, such as per event type?  Hard in a distributed system.
    int sequence

    /**
     * What type of event this instance represents.
     */
    String type

    /**
     * The ISO-8601 timestamp this event is effective of.
     */
    String asOf

    // why do we need an aggregate id?
}
