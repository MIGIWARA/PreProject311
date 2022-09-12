package ru.buffett.PreProject311.crudApi.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.buffett.PreProject311.crudApi.model.User;
import ru.buffett.PreProject311.crudApi.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
@AllArgsConstructor
public class UserController {

    private final UserService personService;

    @GetMapping()
    public String getUsers(ModelMap model) {
        model.addAttribute("people", personService.getAllUsers());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.getUserById(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("person") User user) {
        return "people/new";
    }

    @PostMapping()
    public String add(@ModelAttribute("person") @Valid User user,
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personService.addUser(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String updateUserById(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.getUserById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("person") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/edit";

        personService.updateUser(user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        personService.removeUser(id);
        return "redirect:/people";
    }
}