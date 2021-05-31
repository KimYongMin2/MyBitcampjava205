package myproject.myprojectAPI;

import common.util.ScannerUtil;

import java.util.Calendar;

public class birthConversion {
    public static void main(String[] args) {
        Calendar nowDate = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        long resultDay = 0;

        System.out.print("태어난 년도 : ");
        int year = ScannerUtil.getInputInteger();
        System.out.print("태어난 월 : ");
        int month = ScannerUtil.getInputInteger();
        System.out.print("태어난 일 : ");
        int day = ScannerUtil.getInputInteger();

        birthDate.set(year,month,day);

        resultDay = (nowDate.getTimeInMillis() - birthDate.getTimeInMillis())/(1000*60*60*24);
        System.out.println(resultDay);
    }
}
