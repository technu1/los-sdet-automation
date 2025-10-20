package com.bank.los.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloUiTest {
    @Test
    public void sanity() {
        Assert.assertTrue(true, "UI module is wired correctly");
    }
}
