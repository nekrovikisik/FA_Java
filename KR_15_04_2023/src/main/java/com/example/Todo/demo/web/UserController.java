package com.example.Todo.demo.web;

import com.example.Todo.demo.models.User;
import com.example.Todo.demo.services.TaskService;
import com.example.Todo.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private TaskService taskService;

//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Integer id) {
//            User user = userService.getUser(id);
//            return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/user/registration")
//    public String showRegistrationForm(WebRequest request, Model model) {
//        User user = new User();
//        model.addAttribute("user", user);
//        return "registration";
//    }
//    @RequestMapping("/user/registration")
//    public ResponseEntity<String> formTest(@RequestParam(name = "login") String login,
//                                   @RequestParam(name = "surname") String surname,
//                                   @RequestParam(name = "lastname") String lastname,
//                                   @RequestParam(name = "middlename") String middlename,
//                                   @RequestParam(name = "data", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) java.sql.Date birthday,
//                           Model model) {
//    userService.addUser(login, surname, lastname, middlename, birthday);
////    return "redirect:/{id}";
//    return new ResponseEntity<>("Юзер добавлен", HttpStatus.OK);
//    }

//    @RequestMapping("/registration")
//    public String showRegistrationPage(@ModelAttribute("userRegInfo") User user) {
//        return "reg-page";
//    }
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String login(Model model) {
        return "registration";
    }


}
