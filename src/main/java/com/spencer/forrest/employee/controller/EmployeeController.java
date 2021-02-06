package com.spencer.forrest.employee.controller;

import com.spencer.forrest.employee.dto.EmployeeDTO;
import com.spencer.forrest.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private static final String EMPLOYEE = "employee";

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute(EMPLOYEE, new EmployeeDTO());
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute(EMPLOYEE, employeeService.findById(id));
        return "employees/employee-form";
    }

    @GetMapping("/deleteConfirmation")
    public String deleteConfirmation(@RequestParam("employeeId") int id, Model model) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        String message = "Do you want to delete " + employeeDTO.getFirstName() + " " + employeeDTO.getLastName() + "?";

        model.addAttribute("employeeId", employeeDTO.getId());
        model.addAttribute("message", message);

        return "employees/deletion-confirmation";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int employeeId) {
        employeeService.deleteById(employeeId);
        return "redirect:/employees/list";
    }
}
