package com.lrm.web.tourist;

import com.lrm.po.User;
import com.lrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by limi on 2017/10/15.
 */
@Controller
@RequestMapping("/register")
public class TouristRegisterController {


    @Autowired
    private UserService userService;

    @GetMapping
    public String RegisterPage() {
        return "tourist/register";
    }


    @PostMapping("/toRegister")
    public String register(User user,
                        HttpSession session,
                        RedirectAttributes attributes) {

        User tuser = userService.checkUserIsNew(user.getUsername());
        if (tuser == null) {
        	userService.save(user);
            session.setAttribute("user",user);
            return "tourist/index";
        } else {
        	System.out.print(tuser.getUsername()	+"-------");
            attributes.addFlashAttribute("message", "用户名已经存在");
            return "redirect:/register";
        }
    }


}
