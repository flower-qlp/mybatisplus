package com.mybatisplus.service.adapter;

import com.mybatisplus.bean.Weather;
import com.mybatisplus.mapper.WeatherDao;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

public class WeatherAdapter {
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Resource
    public WeatherDao weatherDao;

    public int testInsertWeather() {
        Map<String, String> map = new HashMap<>();
        map.put("320101", "南京");
        map.put("101010", "北京");
        map.put("320102", "苏州");
        map.put("202020", "上海");

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        Weather weather = null;
        String cityCode = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        List<Weather> weathers = new ArrayList<>();
        while (iterator.hasNext()) {
            weather = new Weather();
            cityCode = iterator.next();
            weather.setCityCode(cityCode);
            weather.setCityName(map.get(cityCode));
            Integer lowTemperature = new Random().nextInt(40);
            weather.setTemperatureLow(lowTemperature);

            for (int i = 0; i < 5; i++) {
                try {
                    Weather weatherClone = weather.clone();
                    Integer diff = new Random().nextInt(5);
                    weatherClone.setTemperatureTop(lowTemperature + diff);
                    calendar.add(Calendar.DATE, i);
                    weatherClone.setWeatherDate(simpleDateFormat.format(calendar.getTime()));
                    weathers.add(weatherClone);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        weatherDao.insertList(weathers);
        return 1;
    }

    ;
}
