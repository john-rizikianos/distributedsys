package gr.hua.aplication;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeResource{
	@GetMapping("/")
	public String home() {
		return ("<h>welcome<h>");
	}
	@GetMapping("/user")
	public String user() {
		return ("<h>welcome user<h>");
	}
	@GetMapping("/admin")
	public String admin() {
		return ("<h>welcome admin<h>");
	}
}

