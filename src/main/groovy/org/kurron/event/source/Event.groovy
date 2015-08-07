package org.kurron.event.source

import groovy.transform.Immutable

/**
 * Base type for all events in the system.
 */
@Immutable
class Event {

    /**
     * Unique identifier for this event instance.
     */
    UUID id

    /**
     * The order that event occurred in the stream.  0 is the first event and Integer.MAX is the most recent event.
     */
    int sequence

    /**
     * What type of event this instance represents.
     */
    String type

    // why do we need an aggregate id?
}
