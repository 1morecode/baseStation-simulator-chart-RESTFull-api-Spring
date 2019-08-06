package com.mycompany.spring.springmvc.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import helper.ConnectionProvider;
//import com.example.ws.model.Greeting;
//import com.example.ws.model.repository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.spring.springjdbc.datacontents.dto.DataContent;
import static java.rmi.server.LogStream.log;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {

    @RequestMapping(value = "/main/data")
    @ResponseBody
    private String getData() {
        Connection con = ConnectionProvider.getConnection();
        String str = "";
        ArrayList<DataContent> dataContents = new ArrayList<DataContent>();
//        ArrayList<String> dataContents = new ArrayList<String>();

        try {
            Statement stmt = con.createStatement();

            String query = "select * from data_sheet1 limit 10";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                System.out.println("=====================================================");
                String dataKey = rs.getString("raw_data_key");
                String dateTime = rs.getString("date_time");
                double methanePpm = rs.getDouble("methane_ppm");
                double calibrationZero = rs.getDouble("calibration_zero");
                double windSpeed = rs.getDouble("wind_speed");
                double windDirection = rs.getDouble("wind_direction");

                DataContent dataContent = new DataContent(dataKey, dateTime, methanePpm, calibrationZero, windSpeed, windDirection);

                dataContents.add(dataContent);

                log("Raw ArrayList ===> " + dataContents);

            }

            // Use this builder to construct a Gson instance when you need to set configuration options other than the default.
//            GsonBuilder gsonBuilder = new GsonBuilder();
            // This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it. 
            // Gson instances are Thread-safe so you can reuse them freely across multiple threads.
            Gson gson = new Gson();

            str = gson.toJson(dataContents);
            log("\nConverted JSONObject ==> " + str);

            Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = prettyGson.toJson(dataContents);

            log("\nPretty JSONObject ==> " + prettyJson);
            return str;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;
    }

    private static void log(Object print) {
        System.out.println(print);

    }
}
