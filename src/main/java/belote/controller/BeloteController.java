package belote.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BeloteController {

	@GetMapping("/beloteArea/connecte")
	public String getMessage() {
		String message = "bonjour Belotiste";

		return message;

	}

}
