package cz.itnetwork.aplikacePojistovny.controllers;

import cz.itnetwork.aplikacePojistovny.models.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import cz.itnetwork.aplikacePojistovny.models.exceptions.DuplicateEmailException;
import cz.itnetwork.aplikacePojistovny.models.exceptions.PasswordsDoNotEqualException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import cz.itnetwork.aplikacePojistovny.models.services.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

        @Autowired
        private UserService userService;

        @GetMapping("login")
        public String renderLogin() {

            return "/pages/account/login.html";
        }

        @GetMapping("register")
        public String renderRegister(@ModelAttribute UserDTO userDTO) {
            return "/pages/account/register";
        }
        @PostMapping("register")
        public String register(
            @Valid @ModelAttribute UserDTO userDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
        ) {
        if (result.hasErrors())
            return renderRegister(userDTO);

        try {
            userService.create(userDTO, false);
        } catch (DuplicateEmailException e) {
            result.rejectValue("email", "error", "Email je již používán.");
            return "/pages/account/register";
        } catch (PasswordsDoNotEqualException e) {
            result.rejectValue("password", "error", "Hesla se nerovnají.");
            result.rejectValue("confirmPassword", "error", "Hesla se nerovnají.");
            return "/pages/account/register";
            }

        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
            return "redirect:/account/login";
        }


    }


