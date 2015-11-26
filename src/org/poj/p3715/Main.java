package org.poj.p3715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // 获得员工数据
        ArrayList<Staff> staffs = getStaffs();
        
        // 计算相隔天数
        calStaffWorkingDays(staffs);
        
        // 打印
        printSortStaffs(staffs);
    }

    /**
     * 计算全部员工的工作天数
     */
    private static void calStaffWorkingDays(ArrayList<Staff> staffs) {
        for (int i = 0; i < staffs.size(); i++) {
            staffs.get(i).setDays(calWorkingDays(staffs.get(i)));
        }
        
        // 排序
        sortStaffs(staffs);
    }
    
    /**
     * 排序
     */
    private static void sortStaffs(ArrayList<Staff> staffs) {
        // TODO
        for (int i = 0; i < staffs.size(); i++) {
            for (int j = i + 1; j < staffs.size(); j++) {
                if (staffs.get(i).getDays() < staffs.get(j).getDays()) {
                    Staff tempStaff = new Staff();
                    tempStaff = staffs.get(i);
                    staffs.set(i, staffs.get(j));
                    staffs.set(j, tempStaff);
                }
            }
        }
        
        for (int i = 0; i < staffs.size(); i++) {
            for (int j = i + 1; j < staffs.size(); j++) {
                if ((staffs.get(i).getSerial() > staffs.get(j).getSerial()) && staffs.get(i).getDays() == staffs.get(j).getDays()) {
                    Staff tempStaff = new Staff();
                    tempStaff = staffs.get(i);
                    staffs.set(i, staffs.get(j));
                    staffs.set(j, tempStaff);
                }
            }
        }
    }
    
    /**
     * 获得全部输入的员工信息
     */
    private static ArrayList<Staff> getStaffs() {
        ArrayList<Staff> staffs = new ArrayList<Staff>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                Staff staff = getStaff(reader.readLine(), i);
                staffs.add(staff);
            }
        } catch (Exception e) {
        }
        
        return staffs;
    }
    
    /**
     * 对得到的一串字符串进行处理
     */
    private static Staff getStaff(String worker, int serial) {
        String[] info = worker.split(" ");
        Staff staff = new Staff();
        staff.setName(info[0]);
        staff.setComeYear(Integer.parseInt(info[1]));
        staff.setComeMonth(Integer.parseInt(info[2]));
        staff.setComeDay(Integer.parseInt(info[3]));
        staff.setGoYear(Integer.parseInt(info[4]));
        staff.setGoMonth(Integer.parseInt(info[5]));
        staff.setGoDay(Integer.parseInt(info[6]));
        staff.setSerial(serial);
        return staff;   
    }
    
    /**
     * 计算员工的工作天数
     */
    private static int calWorkingDays(Staff staff) {
        int days = 0;
        int comeYear = staff.getComeYear();
        int comeMonth = staff.getComeMonth();
        int comeDay = staff.getComeDay();
        int goYear = staff.getGoYear();
        int goMonth = staff.getGoMonth();
        int goDay = staff.getGoDay();
        int[] daysOfMonth = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int y = comeYear; y < goYear; y++) {
            if (isLeapYear(y)) {
                daysOfMonth[2] = 29;
                days += 366;
            } else {
                daysOfMonth[2] = 28;
                days += 365;
            }
        }
        
        days = days + (calDaysofCurrentYear(goYear, goMonth, goDay)) - calDaysofCurrentYear(comeYear, comeMonth, comeDay) + 1;
        
        return days;
    }
    
    /**
     * 计算得到当前日期是当前年的第几天
     */
    private static int calDaysofCurrentYear(int year, int month, int day) {
        int[] daysOfMonth = getDaysofMonth(year);
        int days = 0;
        for (int i = 1; i < month; i++) {
            days += daysOfMonth[i];
        }
        days += day;
        
        return days;
    }
    
    /**
     * 根据年份获得当前年的每月的天数数组
     */
    private static int[] getDaysofMonth(int year) {
        int[] daysOfMonth = {29, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysOfMonth[2] = 29;
            return daysOfMonth;
        }else {
            daysOfMonth[2] = 28;
            return daysOfMonth;
        }
    }
    
    /**
     * 判断是否是闰年
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * 打印员工的工作天数
     */
    private static void printSortStaffs(ArrayList<Staff> staffs) {
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println(staffs.get(i).getName() + " " + staffs.get(i).getDays());
        }
    }
    
    /**
     * 定义一个员工内部类，用于保存单条员工信息
     */
    private static class Staff {
        private String name;
        
        private int comeYear;
        private int comeMonth;
        private int comeDay;
        private int goYear;
        private int goMonth;
        private int goDay;
        
        private int days;
        private int serial;
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getComeYear() {
            return comeYear;
        }
        public void setComeYear(int comeYear) {
            this.comeYear = comeYear;
        }
        public int getComeMonth() {
            return comeMonth;
        }
        public void setComeMonth(int comeMonth) {
            this.comeMonth = comeMonth;
        }
        public int getComeDay() {
            return comeDay;
        }
        public void setComeDay(int comeDay) {
            this.comeDay = comeDay;
        }
        public int getGoYear() {
            return goYear;
        }
        public void setGoYear(int goYear) {
            this.goYear = goYear;
        }
        public int getGoMonth() {
            return goMonth;
        }
        public void setGoMonth(int goMonth) {
            this.goMonth = goMonth;
        }
        public int getGoDay() {
            return goDay;
        }
        public void setGoDay(int goDay) {
            this.goDay = goDay;
        }
        
        public int getDays() {
            return days;
        }
        public void setDays(int days) {
            this.days = days;
        }
        public int getSerial() {
            return serial;
        }
        public void setSerial(int serial) {
            this.serial = serial;
        }
    }
}