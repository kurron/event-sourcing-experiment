package org.kurron.event.source

import groovy.transform.Immutable

/**
 * A user in the system at a particular point in time.
 */
@Immutable
class UserAggregate extends Aggregate {

    String firstName

    String lastName

    String email

    String phone
}
