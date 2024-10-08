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
	    // Python ���� ����
	    String outputScriptPath = "C:\\hyun\\project\\2��\\MULTIPLE_LINEAR_REGRESSION.py";//���̽� ������ġ
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
	        System.out.println("Python ��ũ��Ʈ�� ���������� ����Ǿ����ϴ�.");

	        // ��� ���� Ȯ��
	        String outputString = output.toString().trim();
	        if (outputString.isEmpty()) {
	            System.err.println("Python ��ũ��Ʈ���� �� ����� �߻��߽��ϴ�.");
	            return "redirect:/"; // ���� ó��
	        }

	        // JSON �Ľ�
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            // Map<String, Object>�� ����Ͽ� JSON �Ľ�
	            Map<String, Object> resultMap = objectMapper.readValue(outputString, new TypeReference<Map<String, Object>>() {});
	            model.addAttribute("mse", resultMap.get("mse"));
	            model.addAttribute("rmse", resultMap.get("rmse"));
	            model.addAttribute("y_test", resultMap.get("y_test")); // Object Ÿ������ ������
	            model.addAttribute("y_pred", resultMap.get("y_pred")); // Object Ÿ������ ������
	        } catch (IOException e) {
	            System.err.println("JSON �Ľ� �� ���� �߻�: " + e.getMessage());
	            System.err.println("��� ����: " + outputString); // ��� ���� Ȯ��
	            return "redirect:/"; // ���� ó��
	        }
	    } else {
	        System.err.println("Python ��ũ��Ʈ ���� �� ���� �߻�: " + outputResult);
	        return "redirect:/"; // ���� ó��
	    }

	    return "forecast/MULTIPLE_LINEAR_REGRESSION"; // �� �̸� ��ȯ
	}//end
	
} // end class
