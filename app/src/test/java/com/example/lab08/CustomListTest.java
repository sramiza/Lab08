package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {

    @Test
    public void testHasCity() {

        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");

        list.addCity(calgary);

        // should return true if city exists
        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "AB");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City fakeCity = new City("Calgary", "AB");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(fakeCity);
        });
    }
}