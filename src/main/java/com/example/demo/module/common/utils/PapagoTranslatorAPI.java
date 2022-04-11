package com.example.demo.module.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PapagoTranslatorAPI {


    /*

    @GetMapping("/callApiTest")
    public String callAPITest(){
        HashMap<String, Object> result = new HashMap<String, Object>();

        String jsonInString = "";

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=430156241533f1d058c603178cc3ca0e&targetDt=20120101").build();

            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다  .
            ResponseEntity<String> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, String.class);
            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인

            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }

        return jsonInString;

    }

    //여기 부분이 실 Api 호출 부분입니다.
    //해당 Api 호출하시면 되고 txt 문구만 수정해주시면 됩니다.
    //api 반환값은 jsonInString에 담겨있습니다.
    @RequestMapping("/callTranslatorApi")
    public String callAPI(){
        String txt="안녕하세요.";
        int trLang=200;

        HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";
        String paramTxt = "[{\"src\":\""+txt+"\", \"id\":"+trLang+"}]";;

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders header = new HttpHeaders();

            header.set("Content-Type", "application/json");
            HttpEntity<?> entity = new HttpEntity<>(paramTxt,header);
            String url = "http://0.0.0.0:3000/translator/translate";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
            ResponseEntity<String> resultMap = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
//
//            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
//            ObjectMapper mapper = new ObjectMapper();
//            jsonInString = mapper.writeValueAsString(resultMap.getBody());

            //그저 출력만 하는 부분
            //\u2581띄어쓰기로 띄어쓰기로 바꿔줘야 함
            jsonInString = result.get("body").toString();
            //띄어쓰기 치환하는 부분
            jsonInString = jsonInString.replaceAll("\\u2581", " ");

            //해당 부분까지 완료되어야 띄어스기까지 치환이 완료되어 있는 상태가 됩니다.
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println(e.toString());
        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
        return jsonInString;
    }


    @RequestMapping("/naverAPI")
    public String naverAPI(String fromLang, String targetLang, String text) throws JsonProcessingException {
        //변화값
//        String korean = "안녕하세요.";
//        String targetLan="zh-CN";
//      String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
        //고정값
        String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
        String clientId="3jdut66pni";
        String clientSecret="kygEqBeldoVWdXpNYuxNdroVe41ZZ4rRd2CPCAJ8";

        String txt=null;
        String result = "";
        String line = "";
        try {
            txt = URLEncoder.encode(text, "UTF-8");
            String param = "source="+fromLang+"&target="+targetLang+"&text=" + txt;
            URL url = new URL(apiURL);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(param);
            osw.flush();

            int responseCode = con.getResponseCode();
            result += "responseCode  : " + responseCode;
            result += "\n";

            // 오류 출력
            if (responseCode != 200) {
                Map<String, List<String>> map = con.getRequestProperties();
                result += "Printing Response Header...\n";
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    if (entry.getKey().equals("apikey")) {
                        result += "";
                    } else {
                        result += "Key : " + entry.getKey() + " ,Value : " + entry.getValue();
                    }
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // 값 출력
            while ((line = br.readLine()) != null) {
                result += line + "\n";
            }
            br.close();

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        } catch (IOException e) {
            result = e.getMessage();
        }

        result=result.substring(result.indexOf("Text\":\"")+7, result.lastIndexOf("\""));
        return result;
    }


    @RequestMapping("/realNameAccountInquiryApi")
    public String realNameAccountInquiryApi(){
        String clientID="74597a05-6cd3-44aa-8ed1-7958a1739a9c";
        String clientPass="1432162f-db62-4f5f-8362-4de6dc5abbd1";
        String bankCode = "004";

        HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";

//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpHeaders header = new HttpHeaders();
//
//            header.set("Content-Type", "application/json");
//            HttpEntity<?> entity = new HttpEntity<>(paramTxt,header);
//            String url = "http://0.0.0.0:3000/translator/translate";
//
//            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();
//            ResponseEntity<String> resultMap = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//
//            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
//            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
//            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
////
////            //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
////            ObjectMapper mapper = new ObjectMapper();
////            jsonInString = mapper.writeValueAsString(resultMap.getBody());
//
//            //그저 출력만 하는 부분
//            //\u2581띄어쓰기로 띄어쓰기로 바꿔줘야 함
//            jsonInString = result.get("body").toString();
//            jsonInString = jsonInString.replaceAll("\\u2581", " "); //띄어쓰기 치환 완료
//
//        } catch (HttpClientErrorException | HttpServerErrorException e) {
//            result.put("statusCode", e.getRawStatusCode());
//            result.put("body"  , e.getStatusText());
//            System.out.println(e.toString());
//        } catch (Exception e) {
//            result.put("statusCode", "999");
//            result.put("body"  , "excpetion오류");
//            System.out.println(e.toString());
//        }
        return jsonInString;
    }

     */
}
