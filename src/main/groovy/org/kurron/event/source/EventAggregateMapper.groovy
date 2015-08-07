package org.kurron.event.source

/**
 * Knows how to manage the mapping of a stream of events to arrive at a particular aggregate.
 */
class EventAggregateMapper {

    private final List<? extends Event> seen = []
    private final List<UserAggregate> userAggregates = []

    UserAggregate processEvent( UserCreateEvent event ) {
        assert seen.add( event )
        new UserAggregate( id: UUID.randomUUID(),
                           sequence: userAggregates.size(),
                           type: 'user-aggregate',
                           asOf: event.asOf,
                           userID: event.userID,
                           firstName: event.firstName ,
                           lastName: event.lastName,
                           email: event.email,
                           phone: event.phone,
                           markAsDeleted: false )
    }
    UserAggregate processEvent( UserUpdateEvent event ) {
        assert seen.add( event )
        new UserAggregate( id: UUID.randomUUID(),
                           sequence: userAggregates.size(),
                           type: 'user-aggregate',
                           asOf: event.asOf,
                           userID: event.userID,
                           firstName: event.firstName ,
                           lastName: event.lastName,
                           email: event.email,
                           phone: event.phone,
                           markAsDeleted: false )
    }

    UserAggregate processEvent( UserDeleteEvent event ) {
        assert seen.add( event )
        new UserAggregate( id: UUID.randomUUID(),
                sequence: userAggregates.size(),
                type: 'user-aggregate',
                asOf: event.asOf,
                userID: event.userID,
                markAsDeleted: true )
    }
}
