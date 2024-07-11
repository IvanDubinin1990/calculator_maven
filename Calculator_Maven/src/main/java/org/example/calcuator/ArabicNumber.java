package org.example.calcuator;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ArabicNumber{

    private final Map<String, Double> arabicMap = new HashMap<>();
    private final Map<Double, String> arabicMapConverter = new HashMap<>();

    {
        arabicMap.put("I", 1.0);
        arabicMap.put("II", 2.0);
        arabicMap.put("III", 3.0);
        arabicMap.put("IV", 4.0);
        arabicMap.put("V", 5.0);
        arabicMap.put("VI", 6.0);
        arabicMap.put("VII", 7.0);
        arabicMap.put("VIII", 8.0);
        arabicMap.put("IX", 9.0);
        arabicMap.put("X", 10.0);
    }

    {
        arabicMapConverter.put(1.0, "I"); arabicMapConverter.put(2.0, "II"); arabicMapConverter.put(3.0, "III");
        arabicMapConverter.put(4.0, "IV"); arabicMapConverter.put(5.0, "V"); arabicMapConverter.put(6.0, "VI");
        arabicMapConverter.put(7.0, "VII"); arabicMapConverter.put(8.0, "VIII"); arabicMapConverter.put(9.0, "IX");
        arabicMapConverter.put(10.0, "X"); arabicMapConverter.put(12.0, "XII"); arabicMapConverter.put(14.0, "XIV");
        arabicMapConverter.put(15.0, "XV"); arabicMapConverter.put(16.0, "XVI"); arabicMapConverter.put(18.0, "XVIII");
        arabicMapConverter.put(20.0, "XX"); arabicMapConverter.put(21.0, "XXI"); arabicMapConverter.put(24.0, "XXIV");
        arabicMapConverter.put(25.0, "XXV"); arabicMapConverter.put(27.0, "XXVII"); arabicMapConverter.put(28.0, "XXVIII");
        arabicMapConverter.put(30.0, "XXX"); arabicMapConverter.put(35.0, "XXXV"); arabicMapConverter.put(36.0, "XXXVI");
        arabicMapConverter.put(40.0, "XL"); arabicMapConverter.put(42.0, "XLII"); arabicMapConverter.put(45.0, "XLV");
        arabicMapConverter.put(48.0, "XLVIII"); arabicMapConverter.put(49.0, "XLIX"); arabicMapConverter.put(50.0, "L");
        arabicMapConverter.put(54.0, "LIV"); arabicMapConverter.put(56.0, "LVI"); arabicMapConverter.put(60.0, "LX");
        arabicMapConverter.put(63.0, "LXIII"); arabicMapConverter.put(64.0, "LXIV"); arabicMapConverter.put(70.0, "LXX");
        arabicMapConverter.put(72.0, "LXXII"); arabicMapConverter.put(80.0, "LXXX"); arabicMapConverter.put(81.0, "LXXXI");
        arabicMapConverter.put(90.0, "CX"); arabicMapConverter.put(100.0, "C");
    }
}
