package org.kurron.event.source

import groovy.transform.Immutable
import java.time.LocalDateTime

/**
 * Base aggregate of a logically grouped stream of events.
 */
@Immutable
class Aggregate {

    /**
     * Unique identifier of this instance.
     */
    UUID id

    /**
     * The order that the aggregate occurred in the generation sequence.  0 is the first one and Integer.MAX is the most recent one.
     */
    int sequence

    /**
     * What type of aggregate this instance represents.
     */
    String type

    /**
     * The time this event is effective of.
     */
    LocalDateTime asOf

}
