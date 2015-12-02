#include <stdio.h>
#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

int count_price(int distance){  // ????
	double km = distance / 1000;
	int price = 0;
	if (km <= 6)
		return 3;
	else if (km > 6 && km <= 12)
		return 4;
	else if (km > 12 && km <= 22)
		return 5;
	else if (km >22 && km <= 32)
		return 6;
	else {
		price = ((km - 32) / 20 + 6 + 1);
		return price;
	}
}

int count_distance(vector<pair<string,int> > lines_info, string station_a, string station_b){
	bool flag = false;
	int total_distance = 0;
	for (vector<pair<string, int> >::iterator it = lines_info.begin(); it != lines_info.end(); ++it){
		if (!flag && ((*it).first == station_a || (*it).first == station_b )){
			flag = true;
			total_distance += (*it).second;
			continue;
		}
		if (flag) {
			total_distance += (*it).second;
		}
		if (flag && ((*it).first == station_a || (*it).first == station_b)){
			total_distance -= (*it).second;
			break;
		}
	}
	return total_distance;
}

int main(){
	int cases, L, D, stations_count;
	string name, station_a, station_b, common_station;
	int distance, total_distance;
	bool flag = false;
	char buffer[50];
	cin >> cases;
	for (int m = 0; m < cases; ++m){
		cout << "Case " << m + 1 << ":" <<endl;
		cin >> L >> D;
		vector<pair<string, int> >* lines_info = new vector<pair<string, int> >[L];  // L??????
		map<string, int>* station_names = new map<string, int>[L];  // ????

		// ?????????
		bool isFind = false;
		for (int i = 0; i < L; ++i){
			cin >> stations_count;
			while (stations_count --){  // ????????????????
				if (stations_count != 0)
					cin >> name >> distance;
				else{
					cin >> name;
					distance = 0;
				}
				lines_info[i].push_back(pair<string, int>(name, distance));
				station_names[i].insert(pair<string, int>(name, distance));
				if (i == 1){  // ??????
					if ( !isFind && station_names[0].find(name) != station_names[0].end()){
						common_station = name;
						isFind = true;
					}
				}
			}
		}

		// ????
		while (D--){
			cin >> station_a >> station_b;
			total_distance = 0;
			if (L == 1)
				cout << count_price(count_distance(lines_info[0], station_a, station_b)) << endl;
			else if (L == 2){
				// ???????????????
				if ((station_names[0].find(station_a) != station_names[0].end())
					&& (station_names[0].find(station_b) != station_names[0].end())){
					cout << count_price(count_distance(lines_info[0], station_a, station_b)) << endl;
				}
				// ???????????????
				else if ((station_names[1].find(station_a) != station_names[1].end())
					&& (station_names[1].find(station_b) != station_names[1].end())){
					cout << count_price(count_distance(lines_info[1], station_a, station_b)) << endl;
				}
				// ???????????
				else{
					if (station_names[0].find(station_a) != station_names[0].end())
						cout << count_price(count_distance(lines_info[0], common_station, station_a)
							+ count_distance(lines_info[1], common_station, station_b)) << endl;
					else
						cout << count_price(count_distance(lines_info[1], common_station, station_a)
							+ count_distance(lines_info[0], common_station, station_b)) << endl;
				}
			}
		}
		delete [] lines_info;
	}
	return 0;
}
