package org.poj._p3715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // ���Ա������
        ArrayList<Staff> staffs = getStaffs();
        
        // �����������
        calStaffWorkingDays(staffs);
        
        // ��ӡ
        printSortStaffs(staffs);
    }

    /**
     * ����ȫ��Ա���Ĺ�������
     */
    private static void calStaffWorkingDays(ArrayList<Staff> staffs) {
        for (int i = 0; i < staffs.size(); i++) {
            staffs.get(i).setDays(calWorkingDays(staffs.get(i)));
        }
        
        // ����
        sortStaffs(staffs);
    }
    
    /**
     * ����
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
     * ���ȫ�������Ա����Ϣ
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
     * �Եõ���һ���ַ������д���
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
     * ����Ա���Ĺ�������
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
     * ����õ���ǰ�����ǵ�ǰ��ĵڼ���
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
     * ������ݻ�õ�ǰ���ÿ�µ���������
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
     * �ж��Ƿ�������
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * ��ӡԱ���Ĺ�������
     */
    private static void printSortStaffs(ArrayList<Staff> staffs) {
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println(staffs.get(i).getName() + " " + staffs.get(i).getDays());
        }
    }
    
    /**
     * ����һ��Ա���ڲ��࣬���ڱ��浥��Ա����Ϣ
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