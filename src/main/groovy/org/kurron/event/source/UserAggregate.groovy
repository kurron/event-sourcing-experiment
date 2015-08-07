package org.kurron.event.source
/**
 * A user in the system at a particular point in time.
 */
class UserAggregate extends Aggregate {

    UUID userID

    String firstName

    String lastName

    String email

    String phone

    boolean markAsDeleted
}
