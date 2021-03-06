/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sample.data.jpa.domain.City;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.domain.HotelSummary;

import java.util.List;

public interface CityService {

	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

	City getCity(String name, String country);

	List<Hotel> getHotels(City city);

    public Hotel modifyHotelAddress(String hotelId, String name);

    Hotel findHotel(String hotelName);

    Hotel findHotel(String hotelName, String cityName);

    City findReference(String cityId);
}
