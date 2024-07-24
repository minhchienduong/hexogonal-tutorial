package hu.hirannor.hexagonal.adapter.web.rest.customer.mapping;

import hu.hirannor.hexagonal.adapter.web.rest.customer.model.*;
import hu.hirannor.hexagonal.domain.customer.*;
import hu.hirannor.hexagonal.domain.customer.command.ChangePersonalDetails;

import java.util.function.Function;

/**
 * Maps a {@link ChangeCustomerDetailsModel} model type to {@link ChangePersonalDetails} domain type.
 *
 * @author Mate Karolyi
 */
class ChangeCustomerDetailsModelToDomainMapper implements Function<ChangeCustomerDetailsModel, ChangePersonalDetails> {

    private final String customerId;

    private final Function<GenderModel, Gender> mapGenderModelToDomain;
    private final Function<AddressModel, Address> mapAddressModelToDomain;

    ChangeCustomerDetailsModelToDomainMapper(final String customerId) {
        this(
                customerId,
                CustomerMappingFactory.createGenderModelToDomainMapper(),
                CustomerMappingFactory.createAddressModelToAddressMapper()
        );
    }

    ChangeCustomerDetailsModelToDomainMapper(final String customerId,
                                             final Function<GenderModel, Gender> mapGenderModelToDomain,
                                             final Function<AddressModel, Address> mapAddressModelToDomain) {
        this.customerId = customerId;
        this.mapGenderModelToDomain = mapGenderModelToDomain;
        this.mapAddressModelToDomain = mapAddressModelToDomain;
    }


    @Override
    public ChangePersonalDetails apply(final ChangeCustomerDetailsModel model) {
        if (model == null) return null;

        return new ChangePersonalDetails.Builder()
                .customerId(CustomerId.from(customerId))
                .fullName(FullName.from(model.getFirstName(), model.getLastName()))
                .gender(mapGenderModelToDomain.apply(model.getGender()))
                .birthDate(model.getBirthDate())
                .address(mapAddressModelToDomain.apply(model.getAddress()))
                .email(EmailAddress.from(model.getEmailAddress()))
                .assemble();
    }
}
