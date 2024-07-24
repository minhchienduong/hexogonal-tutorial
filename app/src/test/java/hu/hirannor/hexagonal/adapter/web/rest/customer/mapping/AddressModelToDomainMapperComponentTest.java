package hu.hirannor.hexagonal.adapter.web.rest.customer.mapping;

import hu.hirannor.hexagonal.adapter.web.rest.customer.model.AddressModel;
import hu.hirannor.hexagonal.adapter.web.rest.customer.model.CountryModel;
import hu.hirannor.hexagonal.domain.customer.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("AddressModelToDomainMapper")
class AddressModelToDomainMapperComponentTest {

    private final Function<AddressModel, Address> mapper;

    AddressModelToDomainMapperComponentTest() {
        mapper = new AddressModelToDomainMapper();
    }

    @Test
    @DisplayName("should map null to literal null")
    void testNull() {
        final Address mappingResult = mapper.apply(null);
        assertThat(mappingResult).isNull();
    }

    @Test
    @DisplayName("should map address model to domain address")
    void testValidMapping() {
        final AddressModel input = constructInput();
        final Address expected = constructExpectedDomain();

        final Address result = mapper.apply(input);
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    private Address constructExpectedDomain() {
        return Address.from(
                Country.HUNGARY,
                "Miskolc",
                PostalCode.from(3529),
                "Szentgyörgy str 34"
        );
    }

    private AddressModel constructInput() {
        return new AddressModel()
                .country(CountryModel.HUNGARY)
                .postalCode(3529)
                .city("Miskolc")
                .streetAddress("Szentgyörgy str 34");
    }
}
