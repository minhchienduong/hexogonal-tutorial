package hu.hirannor.hexagonal.domain.customer;

import java.util.regex.Pattern;

/**
 * Immutable record to hold email address of a customer.
 *
 * @param value {@link String} raw value of email address
 * @author Mate Karolyi
 */
public record EmailAddress(String value) {

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\" +
                    ".[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Default constructor
     *
     * @param value raw email address
     */
    public EmailAddress {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("EmailAddress cannot be null!");

        if (!isValidEmailAddress(value)) throw new IllegalArgumentException("Format of email-address is not valid!");
    }

    /**
     * Create an instance of {@link EmailAddress} based on the given parameter
     *
     * @param value email address as raw string
     * @return an instance of {@link EmailAddress}
     */
    public static EmailAddress from(final String value) {
        return new EmailAddress(value);
    }

    /**
     * Validates if the given email address is valid or not
     *
     * @param value email address as raw string
     * @return boolean value of validation result
     */
    private boolean isValidEmailAddress(final String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }
}
