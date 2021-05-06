package com.mybatisplus.controller;

import com.mybatisplus.bean.Weather;
import com.mybatisplus.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Resource
    WeatherService weatherService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @CrossOrigin
    public void testInsert() {
        weatherService.insert(null);
    }

    @RequestMapping(value = "/city/list", method = RequestMethod.GET)
    @CrossOrigin
    public List<String> baseCity() {
        return weatherService.baseCity();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @CrossOrigin
    public List<Weather> selectWeatherByCityName(@RequestParam(value = "search",required = false) String search) {
        return weatherService.selectWeatherByCityName(search);
    }

}
