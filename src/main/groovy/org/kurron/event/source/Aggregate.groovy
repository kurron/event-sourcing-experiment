package org.kurron.event.source
/**
 * Base aggregate of a logically grouped stream of events.
 */
abstract class Aggregate {

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
     * The ISO-8601 timestamp this aggregate is effective of.
     */
    String asOf

}
