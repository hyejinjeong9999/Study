package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import vo.ParsingVO;

public class ParsingDAO {

	public static void getVilageWeather(ParsingVO vo) {

		String urlstr = "http://api.openweathermap.org/data/2.5/weather?q=seoul,kangnam,82&appid=503ca03400fee816b458e72090533724";

		try {
			URL url = new URL(urlstr);
			BufferedReader bf;
			String line;
			String result = "";

			// 날씨 정보를 받아온다.
			bf = new BufferedReader(new InputStreamReader(url.openStream()));

			// 버퍼에 있는 정보를 문자열로 변환.
			while ((line = bf.readLine()) != null) {
				result = result.concat(line);
				 System.out.println(line);
			}

			// 문자열을 JSON으로 파싱
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(result);

			// 지역 출력
			System.out.println("지역 : " + jsonObj.get("name"));
			String name = (String) jsonObj.get("name");
			vo.setName(name);

		

			// 날씨 출력 weather - main
			JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
			JSONObject obj = (JSONObject) weatherArray.get(0);
			System.out.println("날씨 : " + obj.get("main"));

			// 온도 출력(절대온도라서 변환 필요)
			JSONObject mainArray = (JSONObject) jsonObj.get("main");
			double ktemp = Double.parseDouble(mainArray.get("temp").toString());
			double temp = ktemp - 273.15;
			System.out.printf("온도 : %.2f\n", temp);
			vo.setTemp(Double.toString(temp)); //온도 저장
			
			double ftemp = Double.parseDouble(mainArray.get("feels_like").toString());
			double feelLike = ftemp - 273.15;
			vo.setFeelsLike(Double.toString(feelLike)); //체감온도
			
			String humidity = (mainArray.get("humidity")).toString(); //습도
			vo.setHumidity(humidity);
			
			double ftempMax = Double.parseDouble(mainArray.get("temp_max").toString());
			double tempMax = ftempMax - 273.15;
			vo.setTempMax(Double.toString(tempMax));
			
			
			bf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}