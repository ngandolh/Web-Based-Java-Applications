/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author ACER
 */
public class test {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1950, 1, 1); // start date
        LocalDate end = LocalDate.of(2023, 12, 31); // end date
        long days = ChronoUnit.DAYS.between(start, end);
        System.out.println(days);
    }
}
