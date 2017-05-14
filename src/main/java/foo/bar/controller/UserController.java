package foo.bar.controller;

import foo.bar.model.User;
import foo.bar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setProductService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "catalog", method = RequestMethod.GET)
    public String listProduct(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUser", this.userService.listUser());
        return "catalog";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") Integer id){
        this.userService.deleteUser(id);
        return "redirect:/catalog";
    }

    @RequestMapping(value = "/catalog/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == null){
            this.userService.addUser(user);
        }else {
            this.userService.updateUser(user);
        }
        return "redirect:/catalog";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUser", this.userService.listUser());

        return "catalog";
    }
}
