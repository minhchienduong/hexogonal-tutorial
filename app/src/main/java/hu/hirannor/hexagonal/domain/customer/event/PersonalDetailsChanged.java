package hu.hirannor.hexagonal.domain.customer.event;

import hu.hirannor.hexagonal.domain.customer.CustomerId;
import hu.hirannor.hexagonal.infrastructure.event.*;

import java.time.Instant;

/**
 * Domain event, which is fired whenever a detail of a customer has been changed.
 *
 * @param id           {@link EventId} unique identifier of event
 * @param registeredAt {@link Instant} registration time of event
 * @param userId       {@link CustomerId} unique identifier of customer
 * @author Mate Karolyi
 */
public record PersonalDetailsChanged(EventId id, Instant registeredAt, CustomerId userId) implements DomainEvent {

    /**
     * Issues a {@link PersonalDetailsChanged} domain event.
     *
     * @param userId {@link CustomerId}
     * @return an instance of {@link PersonalDetailsChanged} domain event
     */
    public static PersonalDetailsChanged issue(final CustomerId userId) {
        return new PersonalDetailsChanged(EventId.generate(), Event.now(), userId);
    }

}
