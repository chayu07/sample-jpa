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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.jpa.domain.City;
import sample.data.jpa.domain.Hotel;
import sample.data.jpa.domain.Review;
import sample.data.jpa.service.CityService;
import sample.data.jpa.service.HotelService;

import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private CityService cityService;

    @Autowired
    private HotelService hotelService;

    @RequestMapping("/hotels")
    @ResponseBody
    public List<Hotel> findAllHotel() {

        City city = cityService.getCity("Bath", "UK");

        List<Hotel> hotels = cityService.getHotels(city);

        return hotels;
    }

    @RequestMapping("/hotel/modify")
    @ResponseBody
    @Transactional
    public Hotel modifyHotel(@RequestParam String hotelName, @RequestParam String newName ) throws Exception{
        return cityService.modifyHotelAddress(hotelName, newName);
    }

    @RequestMapping("/hotel")
    @ResponseBody
    @Transactional
    public Hotel findHotel(@RequestParam String hotelName, @RequestParam String cityName ) throws Exception{
        return cityService.findHotel(hotelName, cityName);
    }

    @RequestMapping("/commitTest")
    @ResponseBody
    public Hotel commitTest(@RequestParam String hotelName, @RequestParam String newName ) throws Exception{
        Hotel hotel = cityService.modifyHotelAddress(hotelName, newName);
        hotel.modifyAddress("controller");

        return hotel;
    }

    @RequestMapping("/hotel/findId")
    @ResponseBody
    public String findHotelById(@RequestParam String hotelId) throws Exception{
        Hotel hotel = hotelService.findReference(hotelId);
        String id = Long.toString(hotel.getId());

        return id;
    }

    @RequestMapping("/review/hotel")
    @ResponseBody
    public String findReviewById(@RequestParam String reviewId, @RequestParam String hotelId) throws Exception{
        Hotel hotel = hotelService.findReference(hotelId);
        Review review = hotelService.getReview(hotel, Integer.parseInt(reviewId));

        return review.getDetails();
    }
}
