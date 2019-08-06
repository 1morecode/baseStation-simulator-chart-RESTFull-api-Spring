/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.springjdbc.datacontents.dto;

/**
 *
 * @author rahul
 */
public class DataContent {
    
    
    private String raw_data_key;
    private String date_time;
    private double methane_ppm;
    private double calibration_zero;
    private double wind_speed;
    private double wind_direction;

    public DataContent(String raw_data_key, String date_time, double methane_ppm, double callibration_zero, double wind_speed, double wind_direction) {
        this.raw_data_key = raw_data_key;
        this.date_time = date_time;
        this.methane_ppm = methane_ppm;
        this.calibration_zero = callibration_zero;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
    }
    


    public DataContent() {
        
    }


    public String getRaw_data_key() {
        return raw_data_key;
    }

    public void setRaw_data_key(String raw_data_key) {
        this.raw_data_key = raw_data_key;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public double getMethane_ppm() {
        return methane_ppm;
    }

    public void setMethane_ppm(double methane_ppm) {
        this.methane_ppm = methane_ppm;
    }

    public double getCalibration_zero() {
        return calibration_zero;
    }

    public void setCalibration_zero(double calibration_zero) {
        this.calibration_zero = calibration_zero;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(double wind_direction) {
        this.wind_direction = wind_direction;
    }
}
