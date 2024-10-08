package com.kr.kimchi.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ForecastController {

	@GetMapping(value = "forecast/MULTIPLE_LINEAR_REGRESSION")
	public String MULTIPLE_LINEAR_REGRESSION(Model model) throws IOException, InterruptedException {
	    // Python 파일 실행
	    String outputScriptPath = "C:\\hyun\\project\\2차\\MULTIPLE_LINEAR_REGRESSION.py";//파이썬 저장위치
	    ProcessBuilder outputProcessBuilder = new ProcessBuilder("python", outputScriptPath);
	    outputProcessBuilder.redirectErrorStream(true);

	    Process outputProcess = outputProcessBuilder.start();

	    StringBuilder output = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(outputProcess.getInputStream()))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line);
	        }
	    }

	    int outputResult = outputProcess.waitFor();
	    if (outputResult == 0) {
	        System.out.println("Python 스크립트가 성공적으로 실행되었습니다.");

	        // 출력 내용 확인
	        String outputString = output.toString().trim();
	        if (outputString.isEmpty()) {
	            System.err.println("Python 스크립트에서 빈 출력이 발생했습니다.");
	            return "redirect:/"; // 오류 처리
	        }

	        // JSON 파싱
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Map<String, Object>를 사용하여 JSON 파싱
	            Map<String, Object> resultMap = objectMapper.readValue(outputString, new TypeReference<Map<String, Object>>() {});
	            model.addAttribute("mse", resultMap.get("mse"));
	            model.addAttribute("rmse", resultMap.get("rmse"));
	            model.addAttribute("y_test", resultMap.get("y_test")); // Object 타입으로 가져옴
	            model.addAttribute("y_pred", resultMap.get("y_pred")); // Object 타입으로 가져옴
	        } catch (IOException e) {
	            System.err.println("JSON 파싱 중 오류 발생: " + e.getMessage());
	            System.err.println("출력 내용: " + outputString); // 출력 내용 확인
	            return "redirect:/"; // 오류 처리
	        }
	    } else {
	        System.err.println("Python 스크립트 실행 중 오류 발생: " + outputResult);
	        return "redirect:/"; // 오류 처리
	    }

	    return "forecast/MULTIPLE_LINEAR_REGRESSION"; // 뷰 이름 반환
	}//end
	
} // end class
