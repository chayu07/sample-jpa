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

package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.City;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.service.CityService;

import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/helloWorld")
    @ResponseBody
    @Transactional(readOnly = true)
    public String helloWorld() {
        return this.cityService.getCity("Bath", "UK").getName();
    }


    @RequestMapping("/bath/hotels")
    @ResponseBody
    public List<Hotel> findAllHotel() {

        City city = cityService.getCity("Bath", "UK");

        List<Hotel> hotels = cityService.getHotels(city);

        return hotels;
    }

    @RequestMapping("/bath/hotel/modify")
    @ResponseBody
    @Transactional
    public Hotel modifyHotel() throws Exception{
        City city = cityService.getCity("Bath", "UK");
        List<Hotel> hotels = cityService.getHotels(city);

        Hotel hotel = hotels.get(0);
        System.out.println(hotel.getAddress());
        cityService.modifyHotelAddress(hotel, "serivce");
        System.out.println(hotel.getAddress());

        return hotel;
    }
}
