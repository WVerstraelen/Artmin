/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.controller;

import artmin.model.Company;
import artmin.service.CompanyService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author r0798566
 */
@Controller
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    CompanyService companyService;
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newCompany(ModelMap model) {
        Company company = new Company();
        model.addAttribute("company", company);
        model.addAttribute("edit", false);
        return "companyregistration";
    }
    
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveCompany(Company company, BindingResult result, ModelMap model) {
        
        //First check if company already excists
        List<Company> lstCompanys = companyService.findAllCompanies();
        
        for( Company inCompanies : lstCompanys){
            //Controle op UserID, Company Name en Company VAT
            //String userID = user.getId();
            String companyNameOutOfList = inCompanies.getName();
            String companyVATOutOfList = inCompanies.getVat();
            String companyNameNewinList = company.getName();
            String companyVATNewInList = company.getVat();
            
            if (companyNameOutOfList.equals(companyNameNewinList) && companyVATOutOfList.equals(companyVATNewInList)){
                model.addAttribute("message", "Company already excists");
                return "companyregistration";
            }
        }
        
        //Save company to DB
        companyService.saveCompany(company);
        
        //Redirect user to success page
        model.addAttribute("success", "Company " + company.getName() + " registered successfully");
        return "companysuccess";
    }
    
    @RequestMapping(value = {"/edit-{id}-company"}, method = RequestMethod.GET)
    public String editCompany(@PathVariable int id, ModelMap model){
        
        Company company = companyService.findById(id);

        //TODO: Controle op dubbele waarden
        
        model.addAttribute("company", company);
        model.addAttribute("edit", true);
        return "companyregistration";
    }
    
    @RequestMapping(value = {"/edit-{id}-company"}, method = RequestMethod.POST)
    public String updateCompany(Company company, BindingResult result, ModelMap model, @PathVariable int id){
        
        companyService.updateCompany(company);
        
        model.addAttribute("success", "Company " + company.getName() + " registered successfully");
        return "companysuccess";
    }
    
    @RequestMapping(value = {"/delete-{id}-company"}, method=RequestMethod.GET)
    public String deleteCompany(@PathVariable int id, ModelMap model){
        companyService.deleteCompanyById(id);
        model.addAttribute("success", "Company verwijderd");
        return "companysuccess";
    }
    
    @RequestMapping(value = {"", "/list"}, method = RequestMethod.GET)
    public String listCompany(ModelMap model) {
        List<Company> lstCompanies = companyService.findAllCompanies();
        model.addAttribute("companies", lstCompanies);
        return "companylist";
    }
    
}
