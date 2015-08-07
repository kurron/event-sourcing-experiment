package org.kurron.event.source
/**
 * A fact that user information has changed.
 */
class UserUpdateEvent extends Event {

    UUID userID

    String firstName

    String lastName

    String email

    String phone
}
