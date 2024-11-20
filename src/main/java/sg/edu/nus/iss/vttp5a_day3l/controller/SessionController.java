package sg.edu.nus.iss.vttp5a_day3l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/firstpage")
    public String firstPage(){
        return "pageA";
    }

    @PostMapping("/firstpage")
    public String postFromFirstPage(@RequestBody MultiValueMap<String, String> entity, 
    HttpSession session, Model model){
        String fullName = entity.getFirst("fullName");
        session.setAttribute("myname", fullName);
        model.addAttribute("myFullName", fullName);
        return "pageB";
    }

    @GetMapping("/thirdpage")
    public String thirdPage(HttpSession session, Model model){
        model.addAttribute("myFullName", session.getAttribute("myname"));
        return "pageC";
    }

    @GetMapping("/reset")
    public String reset(HttpSession session, Model model){
        session.invalidate();
        return "redirect:/session/firstpage";
    }
}
