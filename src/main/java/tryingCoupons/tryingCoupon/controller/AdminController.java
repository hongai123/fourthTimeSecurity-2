package tryingCoupons.tryingCoupon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tryingCoupons.tryingCoupon.beans.Company;
import tryingCoupons.tryingCoupon.beans.Customer;
import tryingCoupons.tryingCoupon.exceptions.CompanyException;
import tryingCoupons.tryingCoupon.exceptions.CustomerException;
import tryingCoupons.tryingCoupon.services.AdminServicesService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
/**
 * The Controller of admin.
 */
public class AdminController {


    private final AdminServicesService adminServicesMPL;

//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void login(@RequestParam String email, @RequestParam String password) throws LoginException {
//    adminServicesMPL.login(email,password);
//    }

    /**
     * Adding company to data-base.
     * @param company - Getting Company object.
     * @throws CompanyException - if there's a problem with the Company object an exception will be thrown.
     */
    @PostMapping("/addCompany")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCompany(@RequestBody Company company) throws CompanyException {
        adminServicesMPL.addCompany(company);
    }

    /**
     * Update Company details.
     * @param company - Getting Company object.
     * @throws CompanyException -if there's a problem with the Company object an exception will be thrown.
     */
    @PutMapping("/updateCompany")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(@RequestBody Company company) throws CompanyException {
        adminServicesMPL.updateCompany(company);
    }

    /**
     * Delete company from data-base.
     * @param companyId - Getting an id of a company.
     * @throws CompanyException - Thrown if there is no such company.
     */
    @DeleteMapping("/deleCompamy/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCompany(@PathVariable int companyId) throws CompanyException {
        adminServicesMPL.deleteCompany(companyId);
    }

    /**
     * Getting list of all the companies.
     * @return - List of all companies.
     * @throws CompanyException - Will be thrown if there are no companies.
     */
    @GetMapping(value = "/allCompanies")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Company> getAllCompanies() throws CompanyException {
        return adminServicesMPL.getAllCompanies();
    }

    /**
     * Getting one company details by id.
     * @param id - Asking for an id of a company.
     * @return - Company.
     * @throws CompanyException - Will be thrown if company does not exist.
     */
    @GetMapping("/getCompanyByID/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Company getOneCompanyById(@PathVariable int id) throws CompanyException {
        return adminServicesMPL.getCompanyByID(id);
    }

    /**
     * Adding customer to data-base.
     * @param customer - Getting a customer object to upload.
     * @throws CustomerException - Thrown if there is a problem with customer object
     */
    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCustomer(@RequestBody Customer customer) throws CustomerException {
        adminServicesMPL.addCustomer(customer);
    }

    /**
     * Update a customer.
     * @param customer - Getting Customer object.
     * @throws CustomerException - Thrown if there's a problem with Customer object.
     */
    @PutMapping("/updateCustomer")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer customer) throws CustomerException {
        adminServicesMPL.updateCustomer(customer);
    }

    /**
     * Deleting customer.
     * @param customerID - Getting customer ID.
     * @throws CustomerException - if there is no such customer.
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteCustomer/{customerID}")
    public void deleteCustomer(@PathVariable int customerID) throws CustomerException {
        adminServicesMPL.deleteCustomer(customerID);
    }

    /**
     * Getting all customers that are exists.
     * @return - List of all customer.
     * @throws CustomerException - thrown if there are no Customers.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomer() throws CustomerException {
        return adminServicesMPL.getAllCustomer();
    }

    /**
     * Getting one customer by id
     * @param id - Getting customer id
     * @return - Customer object
     * @throws CustomerException - Will be thrown if customer does not exist.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get-one-customer/{id}")
    public Customer customerById(@PathVariable int id) throws CustomerException {
        return adminServicesMPL.findCustomerById(id);
    }


}
