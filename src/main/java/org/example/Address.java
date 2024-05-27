package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    /**
     * check if a postal code is valid. The length of a postal code has to be of 6 or 7
     * and has to respect the proper format
     * @param postalCode the input postal code
     * @return true if the postal code is valid and false if not
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.isEmpty()) {
            return false;
        }

        if (postalCode.length() != 6 && postalCode.length() != 7) {
            return false;
        }

        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";

        if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                if (i % 2 == 0) {
                    if (!letters.contains(c + "")) {
                        return false;
                    }
                }
                if (i % 2 != 0) {
                    if (!numbers.contains(c + "")) {
                        return false;
                    }
                }
            }
        }

        if (postalCode.length() == 7) {
            for (int i = 0; i < postalCode.length(); i++) {
                char c = postalCode.charAt(i);
                switch (i) {
                    case 0, 2, 5 -> {
                        if (!letters.contains(c + "")) {
                            return false;
                        }
                    }
                    case 1, 4, 6 -> {
                        if (!numbers.contains(c + "")) {
                            return false;
                        }
                    }
                    case 3 -> {
                        if (c != ' ') {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
