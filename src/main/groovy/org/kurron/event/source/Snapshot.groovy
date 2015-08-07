package org.kurron.event.source

import groovy.transform.Immutable

/**
 * A base for snapshots in time of a particular aggregate.
 */
@Immutable
class Snapshot {

    /**
     * Unique identifier of this instance.
     */
    UUID id

    /**
     * The order that the snapshot occurred in the generation sequence.  0 is the first one and Integer.MAX is the most recent one.
     */
    int sequence

    /**
     * The ISO-8601 timestamp this snapshot encapsulates up to.
     */
    String asOf
}
