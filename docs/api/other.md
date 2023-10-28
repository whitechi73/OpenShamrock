---
title: 其他接口
icon: feather-alt
---

## 获取城市ADCode

### API 端点

`/get_weather_city_code`

### 参数

| 字段 | 类型   | 必须 | 说明 |
| ---- | ------ | ---- | ---- |
| city | string | 是   | 城市 |

### 响应

```json
[
  {
    "adcode": 10000,
    "province": "广西",
    "city": "柳州"
  }
]
```

## 获取天气

该接口用于获取天气，该接口调用来自QQ官方服务。

### API 端点

`/get_weather`

### 参数

| 字段 | 类型   | 必须 | 说明   |
| ---- | ------ | ---- | ------ |
| code | string | 是   | ADCode |
| city | string | 否   | 城市   |

### 响应

```json
{
  "weatherInfo": {
    "all_astro": [],
    "lifeindex_forecast_list": [],
    "weekly_astro": [],
    "ret": 0,
    "weather_info": {
      "temper": "16",
      "air_humidity": "98",
      "wind_power": "微风",
      "wind_direct": "西南风",
      "weather": "多云",
      "pubtime": "01:40",
      "updatetime": 1695664205,
      "weather_type": "多云",
      "weather_type_id": "202",
      "type_id_new": 2,
      "concrete_type": 2,
      "sunrise": "06:05",
      "sunset": "18:06"
    },
    "air_info": null,
    "forecast_list": {
      "weatherForecast": [
        {
          "day_weather": "阴",
          "night_weather": "多云",
          "day_temper": "22",
          "night_temper": "15",
          "day_wind_direct": "西南风",
          "night_wind_direct": "变向风",
          "day_wind_power": "微风",
          "night_wind_power": "微风",
          "sunrise_time": "06:05",
          "sunset_time": "18:06",
          "pubtime": "202309251800",
          "day": 0,
          "day_weather_type": "阴天",
          "night_weather_type": "多云",
          "day_weather_type_id": "203",
          "night_weather_type_id": "202",
          "day_type_id_new": 3,
          "day_concrete_type": 3,
          "night_type_id_new": 2,
          "night_concrete_type": 2,
          "pm": "82",
          "wind_power_desc": ""
        },
        ...
      ],
      "updatetime": 1695664205,
      "tomorrowPrompt": "",
      "weeklyPrompt": ""
    },
    "forecast": {
      "day_weather": "多云",
      "night_weather": "晴",
      "day_temper": "24",
      "night_temper": "16",
      "day_wind_direct": "变向风",
      "night_wind_direct": "变向风",
      "day_wind_power": "微风",
      "night_wind_power": "微风",
      "sunrise_time": "06:06",
      "sunset_time": "18:04",
      "pubtime": "202309251800",
      "day": 1,
      "day_weather_type": "多云",
      "night_weather_type": "晴",
      "day_weather_type_id": "202",
      "night_weather_type_id": "201",
      "day_type_id_new": 2,
      "day_concrete_type": 2,
      "night_type_id_new": 1,
      "night_concrete_type": 1,
      "pm": "146",
      "wind_power_desc": ""
    },
    "hourinfo_list": null,
    "almanac": "",
    "warning_list": {
      "lst_warning": [],
      "last_proc_time": 0
    },
    "astro": null,
    "city": "北京",
    "area": "",
    "adcode": 110000,
    "area_id": 101010100,
    "en_name": "Beijing",
    "update_time": 1695664205,
    "tips_list": null,
    "lifeindex_list": null,
    "current_time": 1695664515,
    "user_weekly_astro": null,
    "weekly_summary": null
  },
  "qrcode": "data:image/png;base64,...",
  "poster": "",
  "share": {
    "data": {
      "app": "com.tencent.weather.share",
      "config": {
        "autosize": 0,
        "ctime": 1695664515,
        "forward": 0,
        "round": 0,
        "token": "49441099828d62f0ded8112849bce839"
      },
      "desc": "",
      "meta": {
        "share": {
          "adcode": 110000,
          "air_info": null,
          "area": "",
          "city": "北京",
          "current_time": 1695664515,
          "forecast_list": {
            "tomorrowPrompt": "",
            "updatetime": 1695664205,
            "weatherForecast": [
              {
                "day": 0,
                "day_concrete_type": 3,
                "day_temper": "22",
                "day_type_id_new": 3,
                "day_weather": "阴",
                "day_weather_type": "阴天",
                "day_weather_type_id": "203",
                "day_wind_direct": "西南风",
                "day_wind_power": "微风",
                "night_concrete_type": 2,
                "night_temper": "15",
                "night_type_id_new": 2,
                "night_weather": "多云",
                "night_weather_type": "多云",
                "night_weather_type_id": "202",
                "night_wind_direct": "变向风",
                "night_wind_power": "微风",
                "pm": "82",
                "pubtime": "202309251800",
                "sunrise_time": "06:05",
                "sunset_time": "18:06",
                "wind_power_desc": ""
              },
              ...
            ],
            "weeklyPrompt": ""
          },
          "update_time": 1695664205,
          "weather_info": {
            "air_humidity": "98",
            "concrete_type": 2,
            "pubtime": "01:40",
            "sunrise": "06:05",
            "sunset": "18:06",
            "temper": "16",
            "type_id_new": 2,
            "updatetime": 1695664205,
            "weather": "多云",
            "weather_type": "多云",
            "weather_type_id": "202",
            "wind_direct": "西南风",
            "wind_power": "微风"
          }
        }
      },
      "prompt": "[分享]北京 多云 16°",
      "ver": "1.0.0.1",
      "view": "share"
    },
    "code": 0
  }
}
```

## [实验] 上传群图片

该接口用于上传群聊图片, 注意该接口是上传群消息的图片，不是群文件，也不是群相册。

### API 端点

`/upload_group_image`

### 请求类型

`POST`

### 参数

| 字段     | 类型     | 必须  | 说明       |
|--------|--------|-----|----------|
| pic    | string | 是   | 图片base64 |
| sender | int64  | 是   | QQ       |
| troop  | int64  | 是   | 图片发送到的群聊 |
