package org.kurron.event.source
/**
 * A fact that user information has been added to the system.
 */
class UserCreateEvent extends Event {

    UUID userID

    String firstName

    String lastName

    String email

    String phone
}
