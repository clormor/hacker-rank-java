package io.github.clormor.hackerrank.advanced.covariance;

import org.junit.Test;

import static io.github.clormor.hackerrank.advanced.covariance.Flower.FLOWER_NAME;
import static io.github.clormor.hackerrank.advanced.covariance.Jasmine.JASMINE_NAME;
import static io.github.clormor.hackerrank.advanced.covariance.Lily.LILY_NAME;
import static org.junit.Assert.assertEquals;

public class TestRegionalFlowers {

    @Test
    public void test_west_bengal() {
        Region r = new WestBengal();
        assertEquals(JASMINE_NAME, r.yourNationalFlower().whatsYourName());
        assertEquals(JASMINE_NAME, r.yourNationalFlower().getClass().getSimpleName());

        WestBengal w = new WestBengal();
        Jasmine j = w.yourNationalFlower();
        assertEquals(JASMINE_NAME, j.whatsYourName());
    }

    @Test
    public void test_andhra_pradesh() {
        Region r = new AndhraPradesh();
        assertEquals(LILY_NAME, r.yourNationalFlower().whatsYourName());
        assertEquals(LILY_NAME, r.yourNationalFlower().getClass().getSimpleName());

        AndhraPradesh a = new AndhraPradesh();
        Lily l = a.yourNationalFlower();
        assertEquals(LILY_NAME, l.whatsYourName());
    }

    @Test
    public void test_regular_region() {
        Region r = new Region();
        assertEquals(FLOWER_NAME, r.yourNationalFlower().whatsYourName());
        assertEquals("Flower", r.yourNationalFlower().getClass().getSimpleName());
    }
}
