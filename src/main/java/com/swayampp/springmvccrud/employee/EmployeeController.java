package com.swayampp.springmvccrud.employee;

import com.swayampp.springmvccrud.employee.entity.Employee;
import com.swayampp.springmvccrud.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    //Constructor Injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Expose endpoints and call respective Service methods
    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees-list";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("action", "ADD");
        return "saveEmployee-form";
    }

    @GetMapping("/updateEmployeeForm")
    public String updateEmployeeForm(
            @RequestParam("employeeId") int id,
            Model model)
    {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("action", "UPDATE");
        return "saveEmployee-form";
    }

    @PostMapping("/processSaveEmployeeForm")
    public String save(@ModelAttribute Employee employee) {
        System.out.println(employee.toString());
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
