package io.github.clormor.hackerrank.advanced.covariance;

import org.junit.Test;

import static io.github.clormor.hackerrank.advanced.covariance.Flower.flowerName;
import static io.github.clormor.hackerrank.advanced.covariance.Jasmine.jasmineName;
import static io.github.clormor.hackerrank.advanced.covariance.Lily.lilyName;
import static org.junit.Assert.assertEquals;

public class TestRegionalFlowers {

    @Test
    public void test_west_bengal() {
        Region r = new WestBengal();
        assertEquals(jasmineName, r.yourNationalFlower().whatsYourName());
        assertEquals(jasmineName, r.yourNationalFlower().getClass().getSimpleName());

        WestBengal w = new WestBengal();
        Jasmine j = w.yourNationalFlower();
        assertEquals(jasmineName, j.whatsYourName());
    }

    @Test
    public void test_andhra_pradesh() {
        Region r = new AndhraPradesh();
        assertEquals(lilyName, r.yourNationalFlower().whatsYourName());
        assertEquals(lilyName, r.yourNationalFlower().getClass().getSimpleName());

        AndhraPradesh a = new AndhraPradesh();
        Lily l = a.yourNationalFlower();
        assertEquals(lilyName, l.whatsYourName());
    }

    @Test
    public void test_regular_region() {
        Region r = new Region();
        assertEquals(flowerName, r.yourNationalFlower().whatsYourName());
        assertEquals("Flower", r.yourNationalFlower().getClass().getSimpleName());
    }
}
