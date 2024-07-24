package hu.hirannor.hexagonal.adapter.persistence.jpa.customer.mapping;

import hu.hirannor.hexagonal.adapter.persistence.jpa.customer.model.*;
import hu.hirannor.hexagonal.domain.customer.Customer;
import hu.hirannor.hexagonal.domain.customer.Gender;

import java.util.function.Function;

/**
 * Accessor factory for customer related mappings.
 *
 * @author Mate Karolyi
 */
public interface CustomerMappingFactory {

    /**
     * Create an instance of {@link CustomerToModelMapper}, which maps a {@link Customer} domain type
     * to a {@link CustomerModel} model type.
     *
     * @return an instance of {@link CustomerToModelMapper}
     */
    static Function<Customer, CustomerModel> createCustomerToModelMapper() {
        return new CustomerToModelMapper();
    }

    /**
     * Create an instance of {@link CustomerModelToDomainMapper}, which maps a {@link CustomerModel} model type
     * to a {@link Customer} domain type.
     *
     * @return an instance of {@link CustomerModelToDomainMapper}
     */
    static Function<CustomerModel, Customer> createCustomerModelToDomainMapper() {
        return new CustomerModelToDomainMapper();
    }

    /**
     * Create an instance of {@link CustomerViewToDomainMapper}, which maps a {@link CustomerView} view type
     * to a {@link Customer} domain type.
     *
     * @return an instance of {@link CustomerModelToDomainMapper}
     */
    static Function<CustomerView, Customer> createCustomerViewToDomainMapper() {
        return new CustomerViewToDomainMapper();
    }

    /**
     * Create an instance of {@link GenderToModelMapper}, which maps a {@link Gender} domain type
     * to a {@link GenderModel} model type.
     *
     * @return an instance of {@link GenderToModelMapper}
     */
    static Function<Gender, GenderModel> createGenderToModelMapper() {
        return new GenderToModelMapper();
    }

}
