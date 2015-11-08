_**Note:** This Binding is available in TODO and later releases._

## Table of Contents

* [Introduction](#introduction)
* [Binding Configuration](#binding-configuration)
* [Item configuration](#item-configuration)
* [Binding Examples](#binding-examples)
* [Logging](#logging)
* [Known Issues](#known-issues)
* [Change Log](#change-log)

## Introduction

[Nest Labs](https://nest.com/) developed the Wi-Fi enabled Nest Learning Thermostat, the Nest Protect Smoke+CO detector, and the Nest Cam.  These devices are supported by this binding, which communicates with the Nest API over a secure, RESTful API to Nest's servers. Monitoring ambient temperature and humidity, changing HVAC mode, changing heat or cool setpoints, monitoring and changing your "home/away" status, and monitoring your Nest Protects and Cams can be accomplished through this binding.

>For installation of the binding JAR on your system, please see the Wiki page [Bindings](Bindings).

## Binding Configuration

TODO

Edit the file `openhab.cfg` located in `${openhab_home}/configurations/`.  Paste all three of these values into your `openhab.cfg` file like so (using _your_ values):

    ############################## Nest binding ########################################
    #
    # Data refresh interval in ms (optional, defaults to 60000)
    # nest:refresh=60000

    # the Product ID for the product you created (replace with your own)
    nest:client_id=e5cc5558-ec55-4c55-8555-4b95555f4979

    # the Product Secret for the product you created (replace with your own)
    nest:client_secret=ZZo28toiuoiurok4WjUya1Bnc

    # the PIN code that was generated when you authorized your account to allow
    # this product
    nest:pin_code=2JTXXXJL

TODO

## Item configuration

```
/* Nest binding Items */

DateTime Nest_last_connection "Last Nest Connection [%1$tm/%1$td %1$tH:%1$tM]" {nest="<[last_connection]"}

/* Structures - change Home to your structure's name */

String   NestHome_name "Name [%s]"                 {nest="<[structures(Home).name]"}
String   NestHome_country_code "Country Code [%s]" {nest="<[structures(Home).country_code]"}
String   NestHome_postal_code "Postal Code [%s]"   {nest="<[structures(Home).postal_code]"}
String   NestHome_time_zone "Time Zone [%s]"       {nest="<[structures(Home).time_zone]"}
String   NestHome_away "Away [%s]"                 {nest="=[structures(Home).away]"}
String   NestHome_structure_id "Structure Id [%s]" {nest="<[structures(Home).structure_id]"}

/* Thermostats - change Upstairs to your thermostat's name */

Number   NestTStatUpstairs_humidity "Humidity [%d %%]"                                   {nest="<[thermostats(Upstairs).humidity]"}
String   NestTStatUpstairs_locale "Locale [%s]"                                          {nest="<[thermostats(Upstairs).locale]"}
String   NestTStatUpstairs_temperature_scale "Temperature Scale [%s]"                    {nest="<[thermostats(Upstairs).temperature_scale]"}
Switch   NestTStatUpstairs_is_using_emergency_heat "Is using emergency heat [%s]"        {nest="<[thermostats(Upstairs).is_using_emergency_heat]"}
Switch   NestTStatUpstairs_has_fan "Has Fan [%s]"                                        {nest="<[thermostats(Upstairs).has_fan]"}
String   NestTStatUpstairs_software_version "Software Version [%s]"                      {nest="<[thermostats(Upstairs).software_version]"}
Switch   NestTStatUpstairs_has_leaf "Has Leaf [%s]"                                      {nest="<[thermostats(Upstairs).has_leaf]"}
String   NestTStatUpstairs_device_id "Device Id [%s]"                                    {nest="<[thermostats(Upstairs).device_id]"}
String   NestTStatUpstairs_name "Name [%s]"                                              {nest="<[thermostats(Upstairs).name]"}
Switch   NestTStatUpstairs_can_heat "Can Heat [%s]"                                      {nest="<[thermostats(Upstairs).can_heat]"}
Switch   NestTStatUpstairs_can_cool "Can Cool [%s]"                                      {nest="<[thermostats(Upstairs).can_cool]"}
String   NestTStatUpstairs_hvac_mode "HVAC Mode [%s]"                                    {nest="=[thermostats(Upstairs).hvac_mode]"}
Number   NestTStatUpstairs_target_temperature_c "Target Temperature [%.1f °C]"           {nest="=[thermostats(Upstairs).target_temperature_c]"}
Number   NestTStatUpstairs_target_temperature_f "Target Temperature [%.1f °F]"           {nest="=[thermostats(Upstairs).target_temperature_f]"}
Number   NestTStatUpstairs_target_temperature_high_c "Target Temperature High [%.1f °C]" {nest="=[thermostats(Upstairs).target_temperature_high_c]"}
Number   NestTStatUpstairs_target_temperature_high_f "Target Temperature High [%.1f °F]" {nest="=[thermostats(Upstairs).target_temperature_high_f]"}
Number   NestTStatUpstairs_target_temperature_low_c "Target Temperature Low [%.1f °C]"   {nest="=[thermostats(Upstairs).target_temperature_low_c]"}
Number   NestTStatUpstairs_target_temperature_low_f "Target Temperature Low [%.1f °F]"   {nest="=[thermostats(Upstairs).target_temperature_low_f]"}
Number   NestTStatUpstairs_ambient_temperature_c "Ambient Temperature [%.1f °C]"         {nest="<[thermostats(Upstairs).ambient_temperature_c]"}
Number   NestTStatUpstairs_ambient_temperature_f "Ambient Temperature [%.1f °F]"         {nest="<[thermostats(Upstairs).ambient_temperature_f]"}
Number   NestTStatUpstairs_away_temperature_high_c "Away Temperature High [%.1f °C]"     {nest="<[thermostats(Upstairs).away_temperature_high_c]"}
Number   NestTStatUpstairs_away_temperature_high_f "Away Temperature High [%.1f °F]"     {nest="<[thermostats(Upstairs).away_temperature_high_f]"}
Number   NestTStatUpstairs_away_temperature_low_c "Away Temperature Low [%.1f °C]"       {nest="<[thermostats(Upstairs).away_temperature_low_c]"}
Number   NestTStatUpstairs_away_temperature_low_f "Away Temperature Low [%.1f °F]"       {nest="<[thermostats(Upstairs).away_temperature_low_f]"}
String   NestTStatUpstairs_structure_id "Structure Id [%s]"                              {nest="<[thermostats(Upstairs).structure_id]"}
Switch   NestTStatUpstairs_fan_timer_active "Fan Timer Active [%s]"                      {nest="=[thermostats(Upstairs).fan_timer_active]"}
DateTime NestTStatUpstairs_fan_timer_timeout "Fan Timer Timeout [%1$tm/%1$td/%1$tY %1$tH:%1$tM:%1$tS]" <calendar> {nest="<[thermostats(Upstairs).fan_timer_timeout]"}
String   NestTStatUpstairs_name_long "Name Long [%s]"                                    {nest="<[thermostats(Upstairs).name_long]"}
Switch   NestTStatUpstairs_is_online "Is Online [%s]"                                    {nest="<[thermostats(Upstairs).is_online]"}
DateTime NestTStatUpstairs_last_connection "Last Connection [%1$tm/%1$td/%1$tY %1$tH:%1$tM:%1$tS]" <calendar> {nest="<[thermostats(Upstairs).last_connection]"}
/* Added in openHAB 1.7.1: */
String   NestTStatUpstairs_hvac_state "HVAC State [%s]"                                  {nest="<[thermostats(Upstairs).hvac_state]"}

## Binding Examples

* [[Nest Binding Example (new)|Nest-Binding-Example]]

  ![sample](http://watou.github.io/images/nest-binding-example.jpg)

## Logging

In order to configure logging for this binding to be generated in a separate file add the following to your /configuration/logback.xml file;
```xml
<appender name="NESTFILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
   <file>logs/nest.log</file>
   <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
      <!-- weekly rollover and archiving -->
      <fileNamePattern>logs/nest-%d{yyyy-ww}.log.zip</fileNamePattern>
      <!-- keep 30 days' worth of history -->
      <maxHistory>30</maxHistory>
   </rollingPolicy>
   <encoder>
     <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger{30}[:%line]- %msg%n%ex{5}</pattern>
   </encoder>
</appender>
    
<!-- Choose level ERROR, WARN, INFO, DEBUG or TRACE for detailed logging -->
<logger name="org.openhab.binding.nest" level="TRACE" additivity="false">
   <appender-ref ref="NESTFILE" />
</logger>
```

## Known Issues

1. No known issues

## Change Log
### openHAB TODO

* Initial version
