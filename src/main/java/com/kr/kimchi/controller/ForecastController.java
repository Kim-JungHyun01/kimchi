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
	    // Python 파일 실행을 위한 경로 설정
	    String outputScriptPath = "C:\\forecast\\MULTIPLE_LINEAR_REGRESSION.py"; // 파이썬 파일의 경로
	    ProcessBuilder outputProcessBuilder = new ProcessBuilder("python", outputScriptPath);
	    outputProcessBuilder.redirectErrorStream(true); // 에러 스트림을 출력 스트림으로 리디렉션

	    // Python 스크립트 실행
	    Process outputProcess = outputProcessBuilder.start();

	    StringBuilder output = new StringBuilder(); // 출력 내용을 저장하기 위한 StringBuilder
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(outputProcess.getInputStream()))) {
	        String line;
	        // Python 스크립트의 출력 결과를 읽어옴
	        while ((line = reader.readLine()) != null) {
	            output.append(line); // 읽어온 각 라인을 StringBuilder에 추가
	        }
	    }

	    // Python 스크립트의 종료 상태를 확인
	    int outputResult = outputProcess.waitFor();
	    if (outputResult == 0) {
	        System.out.println("Python 스크립트가 성공적으로 실행되었습니다.");

	        // 출력 내용 확인
	        String outputString = output.toString().trim();
	        if (outputString.isEmpty()) {
	            System.err.println("Python 스크립트에서 빈 출력이 발생했습니다.");
	            return "redirect:/"; // 오류 처리: 빈 출력 시 메인 페이지로 리디렉션
	        }

	        // JSON 파싱을 위한 ObjectMapper 생성
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Map<String, Object>를 사용하여 JSON 파싱
	            Map<String, Object> resultMap = objectMapper.readValue(outputString, new TypeReference<Map<String, Object>>() {});
	            // 파싱된 결과를 모델에 추가
	            model.addAttribute("mse", resultMap.get("mse")); // 평균 제곱 오차
	            model.addAttribute("rmse", resultMap.get("rmse")); // 평균 제곱근 오차
	            model.addAttribute("y_test", resultMap.get("y_test")); // 실제 값
	            model.addAttribute("y_pred", resultMap.get("y_pred")); // 예측 값
	        } catch (IOException e) {
	            System.err.println("JSON 파싱 중 오류 발생: " + e.getMessage());
	            System.err.println("출력 내용: " + outputString); // 출력 내용 확인
	            return "redirect:/"; // 오류 처리: JSON 파싱 실패 시 메인 페이지로 리디렉션
	        }
	    } else {
	        System.err.println("Python 스크립트 실행 중 오류 발생: " + outputResult);
	        return "redirect:/"; // 오류 처리: 스크립트 실행 실패 시 메인 페이지로 리디렉션
	    }

	    // 뷰 이름 반환
	    return "forecast/MULTIPLE_LINEAR_REGRESSION"; // 결과를 보여줄 뷰로 이동
	}//end

	// 직선회귀모형
	@GetMapping(value = "forecast/linear_regression")
	public String linear_regression(Model model) throws IOException, InterruptedException {
		// Python 파일 실행
		String outputScriptPath = "C:\\forecast\\linear_regression.py";
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
				Map<String, Object> resultMap = objectMapper.readValue(outputString,
						new TypeReference<Map<String, Object>>() {
						});
				model.addAttribute("x1", resultMap.get("x1")); // Object 타입으로 가져옴
				model.addAttribute("x2", resultMap.get("x2")); // Object 타입으로 가져옴
				model.addAttribute("x3", resultMap.get("x3")); // Object 타입으로 가져옴
				model.addAttribute("y", resultMap.get("y")); // Object 타입으로 가져옴
			} catch (IOException e) {
				System.err.println("JSON 파싱 중 오류 발생: " + e.getMessage());
				System.err.println("출력 내용: " + outputString); // 출력 내용 확인
				return "redirect:/"; // 오류 처리
			}
		} else {
			System.err.println("Python 스크립트 실행 중 오류 발생: " + outputResult);
			return "redirect:/"; // 오류 처리
		}

		return "forecast/linear_regression"; // 뷰 이름 반환
	}// end

//	k근접모델
	@GetMapping(value = "forecast/Kneighbors_Regressor")
	public String Kneighbors_Regressor(Model model) throws IOException, InterruptedException {
		// Python 파일 실행
		String outputScriptPath = "C:\\forecast\\Kneighbors_Regressor.py";// 파이썬 저장위치
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
				Map<String, Object> resultMap = objectMapper.readValue(outputString,
						new TypeReference<Map<String, Object>>() {
						});
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

		return "forecast/Kneighbors_Regressor"; // 뷰 이름 반환
	}// end

//	앙상블모델_의식결정트리, 랜덤프레스트
	@GetMapping(value = "forecast/Ensemble_Learning")
	public String Ensemble_Learning(Model model) throws IOException, InterruptedException {
		// Python 파일 실행Ensemble_Learning
		String outputScriptPath = "C:\\forecast\\Ensemble_Learning.py";// 파이썬 저장위치
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
				Map<String, Object> resultMap = objectMapper.readValue(outputString,
						new TypeReference<Map<String, Object>>() {
						});
				model.addAttribute("mse2", resultMap.get("mse2"));
				model.addAttribute("rmse2", resultMap.get("rmse2"));
				model.addAttribute("mse3", resultMap.get("mse3"));
				model.addAttribute("rmse3", resultMap.get("rmse3"));
				model.addAttribute("y2_test", resultMap.get("y2_test")); // Object 타입으로 가져옴
				model.addAttribute("y2_pred", resultMap.get("y2_pred")); // Object 타입으로 가져옴
				model.addAttribute("y3_test", resultMap.get("y3_test")); // Object 타입으로 가져옴
				model.addAttribute("y3_pred", resultMap.get("y3_pred")); // Object 타입으로 가져옴
//	            2,3추가하기

			} catch (IOException e) {
				System.err.println("JSON 파싱 중 오류 발생: " + e.getMessage());
				System.err.println("출력 내용: " + outputString); // 출력 내용 확인
				return "redirect:/"; // 오류 처리
			}
		} else {
			System.err.println("Python 스크립트 실행 중 오류 발생: " + outputResult);
			return "redirect:/"; // 오류 처리
		}

		return "forecast/Ensemble_Learning"; // 뷰 이름 반환
	}// end

} // end class
