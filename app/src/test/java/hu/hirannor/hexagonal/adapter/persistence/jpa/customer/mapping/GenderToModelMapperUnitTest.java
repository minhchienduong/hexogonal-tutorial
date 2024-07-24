package hu.hirannor.hexagonal.adapter.persistence.jpa.customer.mapping;

import hu.hirannor.hexagonal.adapter.persistence.jpa.customer.model.GenderModel;
import hu.hirannor.hexagonal.domain.customer.Gender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GenderToModelMapper")
class GenderToModelMapperUnitTest {

    private final Function<Gender, GenderModel> mapper;

    GenderToModelMapperUnitTest() {
        mapper = new GenderToModelMapper();
    }

    private static Stream<Arguments> supplyValidCases() {
        return Stream.of(
                Arguments.of(GenderModel.MALE, Gender.MALE),
                Arguments.of(GenderModel.FEMALE, Gender.FEMALE)
        );
    }

    @Test
    @DisplayName("should map null to literal null")
    void testNull() {
        final GenderModel mappingResult = mapper.apply(null);
        assertThat(mappingResult).isNull();
    }

    @DisplayName("should map")
    @ParameterizedTest(name = "{0} to {1}")
    @MethodSource("supplyValidCases")
    void testValidCases(final GenderModel model, final Gender domain) {
        final GenderModel mappingResult = mapper.apply(domain);

        assertThat(mappingResult).isEqualTo(model);
    }
}
