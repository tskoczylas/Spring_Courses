package com.onlineshop.toms.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainUtilsTest {

    @Test
    void isIntegerAndNotNull() {
        //givving
        boolean first = MainUtils.isIntegerAndNotNull("thisIsNotInt");
        boolean secound=MainUtils.isIntegerAndNotNull("9999999999999999999999");
        boolean third = MainUtils.isIntegerAndNotNull("99");
        boolean fourth=MainUtils.isIntegerAndNotNull(null);

        //then
        assertFalse(first);
        assertFalse(secound);
        assertFalse(fourth);

        assertTrue(third);


    }


}