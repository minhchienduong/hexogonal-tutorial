package hu.hirannor.hexagonal.application.usecase;

import hu.hirannor.hexagonal.domain.customer.Customer;
import hu.hirannor.hexagonal.domain.customer.CustomerId;
import hu.hirannor.hexagonal.domain.customer.query.FilterCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Customer related use case for displaying customers.
 *
 * @author Mate Karolyi
 */
public interface CustomerDisplay {

    /**
     * Displays all available customers.
     *
     * @param criteria {@link FilterCriteria} criteria to filter
     * @return a list of {@link Customer} customers.
     */
    List<Customer> displayAllBy(FilterCriteria criteria);

    /**
     * Displays a customer by {@link CustomerId} value.
     *
     * @param customerId {@link CustomerId} unique identifier of a customer
     * @return found customer
     */
    Optional<Customer> displayBy(CustomerId customerId);

}
