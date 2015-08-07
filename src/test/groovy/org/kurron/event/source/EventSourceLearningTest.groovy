/*
 * Copyright (c) 2015 Ronald D. Kurr kurr@jvmguy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kurron.event.source

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom
import spock.lang.Specification

/**
 * A test to exercise some of the event source abstractions.
 */
class EventSourceLearningTest extends Specification{

    def sut = new EventAggregateMapper()

    def 'exercise event sourcing'() {

        given: 'an event stream'
        def createEvent = generateCreateEvent()
        def updateEvents = generateUpdateEvents( 10, createEvent )
        def deleteEvent = generateDeleteEvent( updateEvents.last() )

        when: 'events are processed'
        def aggregates = [sut.processEvent( createEvent )]
        updateEvents.each { aggregates << sut.processEvent( it ) }
        aggregates << sut.processEvent( deleteEvent )

        then: 'each event triggers a new aggregate'
        aggregates.size() == updateEvents.size() + 2
    }

    static String randomString() {
        Integer.toHexString( ThreadLocalRandom.current().nextInt( Integer.MAX_VALUE ) )
    }

    static UserCreateEvent generateCreateEvent() {
        new UserCreateEvent( id: UUID.randomUUID(),
                             sequence: 1,
                             type: 'user-create',
                             asOf: LocalDateTime.now().format( DateTimeFormatter.ISO_DATE_TIME ),
                             userID: UUID.randomUUID(),
                             firstName: randomString(),
                             lastName: randomString(),
                             email: randomString(),
                             phone: randomString() )
    }

    static UserDeleteEvent generateDeleteEvent( UserUpdateEvent lastUpdateEvent ) {
        def updateTime = LocalDateTime.parse( lastUpdateEvent.asOf )
        new UserDeleteEvent( id: UUID.randomUUID(),
                             sequence: 1,
                             type: 'user-delete',
                             asOf: updateTime.plusDays( 1 ).format( DateTimeFormatter.ISO_DATE_TIME ),
                             userID: UUID.randomUUID() )
    }

    static List<UserUpdateEvent> generateUpdateEvents( int howMany, UserCreateEvent createEvent ) {
        def createTime = LocalDateTime.parse( createEvent.asOf )
        (1..howMany).collect {
            new UserUpdateEvent( id: UUID.randomUUID(),
                                 sequence: it,
                                 type: 'user-update',
                                 asOf: createTime.plusDays( it ).format( DateTimeFormatter.ISO_DATE_TIME ),
                                 userID: createEvent.userID,
                                 firstName: randomString(),
                                 lastName: randomString(),
                                 email: randomString(),
                                 phone: randomString() )
        }
    }
}
