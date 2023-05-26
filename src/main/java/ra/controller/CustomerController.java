package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Customer;
import ra.service.ICustomerService;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView mav = new ModelAndView("/customer/create");
        mav.addObject("customer", new Customer());
        return mav;
    }
    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.insertWithStoredProcedure(customer);
        ModelAndView mav= new ModelAndView("/customer/create");
        mav.addObject("customer", new Customer());
        mav.addObject("message", "New customer created successfully");
        return mav;
    }






}
