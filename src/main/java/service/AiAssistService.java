package service;

//import org.apache.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

//import com.google.api.client.util.Value;
import org.springframework.beans.factory.annotation.Value;


@Service
public class AiAssistService {
	
	@Value("${gemini.api.key}")
	public String apikey;
	
	
	public String explainGap(String skill) {
		try {
			String url="https://generativelanguage.googleapis.com/v1/models/gemini-2.5-flash:generateContent?key="
					+ apikey;
			
			
			String body = """
					{
					  "contents":[
					    {
					      "parts":[
					        {
					          "text":"Explain why %s is important for backend interviews. Do not give decisions.be like mentor and give short and crisp"
					        }
					      ]
					    }
					  ]
					}
					""".formatted(skill);

			
//		}""".formatted(skill);
			
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity=new HttpEntity<>(body, headers);
		ResponseEntity<String> response=restTemplate.postForEntity(url, entity, String.class);
		
		return response.getBody();
		
		}
//		catch(Exception e) {
//			return "This skill is important for backend interviews and system reliability"+apikey;
//		}
		catch(Exception e) {
//			System.out.println("API Key: " + apikey);

		    e.printStackTrace();
		    return "Error: " + e.getMessage();
		}

		
	}
}
		
		
//		return switch (skill.toLowerCase()) {
//		case "dsa" -> "DSA is critical for backend asap";
//		case "core java" -> "Core Java ensures you understood";
//		default -> "This skill improves";
//		};
//	}
//
//	public String Interviewfeedback(String ansQuality) {
//		if("weak".equalsIgnoreCase(ansQuality)) {
//			return "Focus on structure:definition->example->real use case";
//		}
//		return "Good answer.";
//				
//	}
//	public String WeeklyMotivation(int tasksCompleted) {
//		if (tasksCompleted >=5) {
//			return "Excellent consistency";
//		}
////		return "small steps matter";
//	}
//	}
//}
