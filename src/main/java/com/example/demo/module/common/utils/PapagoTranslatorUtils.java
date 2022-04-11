package com.example.demo.module.common.utils;

import com.example.demo.module.file.domain.file.FileTrDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PapagoTranslatorUtils {
    private final String clientId = "3jdut66pni";//애플리케이션 클라이언트 아이디값";
    private final String clientSecret = "kygEqBeldoVWdXpNYuxNdroVe41ZZ4rRd2CPCAJ8";//애플리케이션 클라이언트 시크릿값";


    @ResponseBody
    @PostMapping("/translator/tlText")
    public String translatePapago(@RequestBody FileTrDto data) throws Exception{
        System.out.println("/tlText");
        System.out.println("data : " + data);
        String srcLang = data.getTr1();
        String dstLang = data.getTr2();
        System.out.println("srcLang : " + srcLang + ", dstLang : " + dstLang);

        JSONObject result = this.translate(data.getOgTxt(), this.verifyLang(srcLang), this.verifyLang(dstLang));
        System.out.println("result : " + result);
        String message = result.getAsString("message");

        JSONParser jsonParser = new JSONParser();
        Object message2 = jsonParser.parse(message);
        JSONObject jsonMessage = (JSONObject) message2;
        System.out.println("jsonMessage : " + jsonMessage);

        String result_ = jsonMessage.getAsString("result");
        Object result2 = jsonParser.parse(result_);
        JSONObject jsonResult = (JSONObject) result2;
        System.out.println("jsonResult : " + jsonResult);

        String translatedTxt = jsonResult.getAsString("translatedText");
        System.out.println("translatedText : " + translatedTxt);
        return translatedTxt;
    }

    public String verifyLang(String lang) {
        if(lang.equals("한"))
            return "ko";
        else if(lang.equals("중"))
            return "zh-CN";
        else if(lang.equals("일"))
            return "ja";
        else if(lang.equals("영"))
            return "en";
        else if(lang.equals("독"))
            return "de";
        else if(lang.equals("불"))
            return "fr";
        else return null;
    }

    public JSONObject translate(String text) {
        String result = "";
        try {
            text = URLEncoder.encode(text, "UTF-8");

            //connection
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            // post request
            String postParams = "source=ko&target=en&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("Papago Translator API 안");
            result = response.toString();
            System.out.println("result : " + result);

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(result);
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println("jsonObj : " + jsonObj);

            return jsonObj;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public JSONObject translate(String text, String srcStr, String dstStr) {
        String result = "";
        try {
            text = URLEncoder.encode(text, "UTF-8");

            //connection
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            // post request
            String postParams = "source=" + srcStr + "&target=" + dstStr + "&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println("Papago Translator API 안");
            result = response.toString();
            System.out.println(result);

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(result);
            JSONObject jsonObj = (JSONObject) obj;
            System.out.println("jsonObj : " + jsonObj);

            return jsonObj;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;


    }
}
