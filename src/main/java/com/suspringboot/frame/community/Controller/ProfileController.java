package com.suspringboot.frame.community.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ProfileController {
    @GetMapping("/profile/{action}")
    public String publish(@PathVariable(name = "action")String action, Model model) {
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }

        return "publish";
    }
}
