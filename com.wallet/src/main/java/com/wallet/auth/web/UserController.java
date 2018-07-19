package com.wallet.auth.web;

import com.wallet.auth.model.CardInfo;
import com.wallet.auth.model.User;
import com.wallet.auth.repository.UserRepository;
import com.wallet.auth.service.AddCardService;
import com.wallet.auth.service.AddMoneyService;
import com.wallet.auth.service.SecurityService;
import com.wallet.auth.service.SendMoneyService;
import com.wallet.auth.service.TransactionsService;
import com.wallet.auth.service.UserService;
import com.wallet.auth.validator.UserValidator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private AddCardService addCardService;
    
    @Autowired
    private AddMoneyService addMoneyService;
    
    @Autowired
    private TransactionsService transactionsService;
    
    @Autowired
    private SendMoneyService sendMoneyService;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
    
    @RequestMapping(value="/profile", method =RequestMethod.GET)
    public String viewProfilePage(Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName();
    	User user = userService.findByUsername(name);
    	model.addAttribute("user", user);
    	return "profile";
    }
    @RequestMapping(value="/addcard", method = RequestMethod.GET)
    public String viewAddCardPage(Model model)
    {
    	//System.out.println("*************in get addcard*********");
    	return "addcard";
    }
    
    @RequestMapping(value="/addcard", method = RequestMethod.POST)
    public String viewAddCardPage(@RequestParam(name="bankname") String bankName, @RequestParam(name="cardnumber") String cardNumber)
    {
    	System.out.println("*************in post addcard*********");
    	System.out.println(bankName + " "+cardNumber);
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	addCardService.save(bankName, cardNumber, auth.getName());
    	return "addmoney";
    }
    @RequestMapping(value="/addmoney", method = RequestMethod.GET)
    public String viewAddMoneyPage(Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
    	List<CardInfo> list = new ArrayList(user.getCardInfo());
    	model.addAttribute("c",list);
    	return "addmoney";
    }
    @RequestMapping(value="/addmoney", method = RequestMethod.POST)
    public String viewAddMoneyPage(@RequestParam(name="amount") String amount, @RequestParam(name="fromcard") String fromcard ,Model model)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	addMoneyService.updateBalance(auth.getName(),Long.parseLong(amount));
    	transactionsService.save(auth.getName(), auth.getName(), Long.parseLong(amount));
    	return "sendmoney";
    }
    @RequestMapping(value="/sendmoney",method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model)
    {
    
    	
    	return "sendmoney";
    }
    @RequestMapping(value="/sendmoney",method = RequestMethod.POST)
    public String viewSendMoneyPage(@RequestParam(name="touser") String touser, @RequestParam(name="amount") String amount,Model model,@RequestParam(name="fromcard") String fromcard)
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	sendMoneyService.updateBalance(auth.getName(), touser,Long.parseLong(amount));
    	transactionsService.save(auth.getName(), touser, Long.parseLong(amount));
    	return "sendmoney";
    }
}
