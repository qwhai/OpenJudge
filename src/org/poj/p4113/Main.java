package org.poj.p4113;

/**
 * 
 题目链接：http://bailian.openjudge.cn/practice/4113/ 

 样例输入
2
1 2
5 YuanMingYuan 1295 BeiJingDaXueDongMen 887 ZhongGuanCun 900 HaiDianHuangZhuang 1063 RenMinDaXue
BeiJingDaXueDongMen ZhongGuanCun
BeiJingDaXueDongMen RenMinDaXue
2 1
10 YuanMingYuan 1295 BeiJingDaXueDongMen 887 ZhongGuanCun 900 HaiDianHuangZhuang 1063 RenMinDaXue 2709 GuaJiaTuShuGuan 1958 XiZhiMen 3225 XiSi 1880 XiDan 815 XuanWuMen
7 JunShiBoWuGuan 1166 MuXiDi 1715 FuXingMen 1590 XiDan 1217 TianAnMenXi 925 TianAnMenDong 852 WangFuJing
BeiJingDaXueDongMen TianAnMenDong

 样例输出
Case 1:
3
3
Case 2:
5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(reader.readLine());
            int n = cases;
            while (n-- > 0) {
                String[] ld = reader.readLine().split(" ");
                int l = Integer.parseInt(ld[0]);
                int d = Integer.parseInt(ld[1]);
                Line[] lines = new Line[l];
                String[][] startEnds = new String[d][2];

                for (int i = 0; i < lines.length; i++) {
                    lines[i] = getLineInfo(reader.readLine());
                }

                for (int i = 0; i < startEnds.length; i++) {
                    startEnds[i] = reader.readLine().split(" ");
                }

                System.out.println("Case " + (cases - n) + ":");
                for (int i = 0; i < startEnds.length; i++) {
                    int dis = distance(lines, startEnds[i]);
                    price(dis);
                }
            }
        } catch (Exception e) {
        }
    }

    private static Line getLineInfo(String info) {
        String[] infos = info.split(" ");
        Line line = new Line(Integer.parseInt(infos[0]));
        for (int i = 1; i < infos.length; i++) {
            if (i % 2 == 0) {
                line.addDistance(Integer.parseInt(infos[i]), (i - 1) / 2);
            } else {
                line.addStation(new Station(infos[i]), i / 2);
            }
        }

        return line;
    }
    
    private static int distance(Line[] lines, String[] startEnd) {
        int distance = 0;
        if (lines.length == 1) {
            distance = singleLineDistance(lines, startEnd);
        } else {
            int[] lineCrossIndex = new int[2];
            int[] startCoordinate = new int[2];
            int[] endCoordinate = new int[2];
            // 找交叉点
            for (int i = 0; i < lines[0].stations.length; i++) {
                lineCrossIndex[1] = lines[1].containsIndex(lines[0].stations[i]);
                if (lineCrossIndex[1] >= 0) {
                    lines[0].stations[i].setCross(true);
                    lineCrossIndex[0] = i;
                    break;
                }
                
                if (lines[0].stations[i].name.equals(startEnd[0])) {
                    startCoordinate[0] = 0;
                    startCoordinate[1] = i;
                }
                
                if (lines[0].stations[i].name.equals(startEnd[1])) {
                    endCoordinate[0] = 0;
                    endCoordinate[1] = i;
                }
            }
            
            for (int i = 0; i < lines[1].stations.length; i++) {
                if (lines[0].stations[i].name.equals(startEnd[0])) {
                    startCoordinate[0] = 1;
                    startCoordinate[1] = i;
                }
                
                if (lines[0].stations[i].name.equals(startEnd[1])) {
                    endCoordinate[0] = 1;
                    endCoordinate[1] = i;
                }
            }
            
            int start = Math.min(startCoordinate[1], lineCrossIndex[startCoordinate[0]]);
            int end = Math.max(startCoordinate[1], lineCrossIndex[startCoordinate[0]]);
            for (int i = start; i < end; i++) {
                distance += lines[startCoordinate[0]].distances[i];
            }
            
            start = Math.min(endCoordinate[1], lineCrossIndex[endCoordinate[0]]);
            end = Math.max(endCoordinate[1], lineCrossIndex[endCoordinate[0]]);
            for (int i = start; i < end; i++) {
                distance += lines[endCoordinate[0]].distances[i];
            }
        }
        
        return distance;
    }
    
    private static int singleLineDistance(Line[] lines, String[] startEnd) {
        int distance = 0;
        int foundFlag = 0; // 0:未进站    1:进站    2:出站
        for (int i = 0; i < lines[0].stations.length; i++) {
            if (foundFlag == 1) {
                distance += lines[0].distances[i - 1];
            }
            
            if (lines[0].stations[i].name.equals(startEnd[0]) || lines[0].stations[i].name.equals(startEnd[1])) {
                foundFlag++;
            }
        }
        
        return distance;
    }
    
    private static void price(int distance) {
        System.err.println(distance);
        int p = 0;
        if (distance <= 6000) {
            p = 3;
        } else if (6000 < distance && distance <= 12000) {
            p = 4;
        } else if (12000 < distance && distance <= 22000) {
            p = 5;
        } else if (22000 < distance && distance <= 32000) {
            p = 6;
        } else {
            p = 6 + (distance - 32000) / 20000 + ((distance - 32000) % 20000 > 0 ? 1 : 0);
        }
        
        System.out.println(p);
    }
}

/**
 * 地铁线路
 */
class Line {
    Station[] stations;
    int[] distances;

    public Line(int stationCount) {
        stations = new Station[stationCount];
        distances = new int[stationCount - 1];
    }

    public Station[] getStations() {
        return stations;
    }

    public int[] getDistances() {
        return distances;
    }

    public void addStation(Station station, int index) {
        stations[index] = station;
    }

    public void addDistance(int distance, int index) {
        distances[index] = distance;
    }
    
    public int containsIndex(Station station) {
        for (int i = 0; i < stations.length; i++) {
            if (station.name.equals(stations[i].name)) {
                stations[i].setCross(true);
                return i;
            }
        }
        
        return -1;
    }
}

/**
 * 地铁站
 */
class Station {
    String name;
    boolean isCross;

    public Station(String name) {
        this.name = name;
        isCross = false;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCross() {
        return isCross;
    }

    public void setCross(boolean isCross) {
        this.isCross = isCross;
    }
}
