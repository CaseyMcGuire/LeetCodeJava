package main.com.leetcode.problems.problem0273;

import java.util.Arrays;


public class Solution {

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    Number[] places = new Number[]{Number.BILLION, Number.MILLION, Number.THOUSAND, Number.HUNDRED};
    StringBuilder wordBuilder = new StringBuilder();

    for (Number place : places) {
      int numForCurrentPlace = num / place.num;
      if (numForCurrentPlace != 0) {
        if (wordBuilder.length() != 0) {
          wordBuilder.append(" ");
        }
        wordBuilder.append(getThreeDigitNumAsWord(numForCurrentPlace)).append(" ").append(place.name);
      }
      num -= (numForCurrentPlace * place.num);
    }
    if (num > 0) {
      if (wordBuilder.length() != 0) {
        wordBuilder.append(" ");
      }
      wordBuilder.append(getThreeDigitNumAsWord(num));
    }
    return wordBuilder.toString();
  }

  private String getThreeDigitNumAsWord(int num) {
    StringBuilder wordBuilder = new StringBuilder();
    int hundredPlaces = num / 100;
    if (hundredPlaces != 0) {
      wordBuilder.append(Number.getSingleDigitNumber(hundredPlaces).name).append(" ").append(Number.HUNDRED.name);
      num -= (hundredPlaces * 100);
    }
    if (num != 0) {
      if (wordBuilder.length() != 0) {
        wordBuilder.append(" ");
      }
      wordBuilder.append(getTwoDigitNumAsWord(num));
    }
    return wordBuilder.toString();
  }

  private String getTwoDigitNumAsWord(int num) {
    if (num < 10) {
      return Number.getSingleDigitNumber(num).name;
    }
    else if (num < 20) {
      return Number.getTeenNumber(num).name;
    }

    int twoDigitPlaces = num / 10;
    StringBuilder wordBuilder = new StringBuilder();
    if (twoDigitPlaces != 0) {
      wordBuilder.append(Number.getDoubleDigitNonTeenNumber(twoDigitPlaces * 10).name);
      num -= (twoDigitPlaces * 10);
    }
    if (num != 0) {
      if (wordBuilder.length() != 0) {
        wordBuilder.append(" ");
      }
      wordBuilder.append(Number.getSingleDigitNumber(num).name);
    }
    return wordBuilder.toString();
  }


  enum Number {
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    ELEVEN(11, "Eleven"),
    TWELVE(12, "Twelve"),
    THIRTEEN(13, "Thirteen"),
    FOURTEEN(14, "Fourteen"),
    FIFTEEN(15, "Fifteen"),
    SIXTEEN(16, "Sixteen"),
    SEVENTEEN(17, "Seventeen"),
    EIGHTEEN(18, "Eighteen"),
    NINETEEN(19, "Nineteen"),
    TWENTY(20, "Twenty"),
    THIRTY(30, "Thirty"),
    FORTY(40, "Forty"),
    FIFTY(50, "Fifty"),
    SIXTY(60, "Sixty"),
    SEVENTY(70, "Seventy"),
    EIGHTY(80, "Eighty"),
    NINETY(90, "Ninety"),
    HUNDRED(100, "Hundred"),
    THOUSAND(1000, "Thousand"),
    MILLION(1_000_000, "Million"),
    BILLION(1_000_000_000, "Billion");

    private int num;
    private String name;

    Number(int num, String name) {
      this.num = num;
      this.name = name;
    }

    public static Number getSingleDigitNumber(int num) {
      for (Number singleDigitNum : Arrays.asList(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)) {
        if (singleDigitNum.num == num) {
          return singleDigitNum;
        }
      }
      return null;
    }

    public static Number getTeenNumber(int num) {
      for (Number teenNumber : Arrays.asList(TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN, FIFTEEN, SIXTEEN, SEVENTEEN, EIGHTEEN, NINETEEN)) {
        if (teenNumber.num == num) {
          return teenNumber;
        }
      }
      return null;
    }

    public static Number getDoubleDigitNonTeenNumber(int num) {
      for (Number doubleDigitNum : Arrays.asList(TWENTY, THIRTY, FORTY, FIFTY, SIXTY, SEVENTY, EIGHTY, NINETY)) {
        if (doubleDigitNum.num == num) {
          return doubleDigitNum;
        }
      }
      return null;
    }

  }
}
