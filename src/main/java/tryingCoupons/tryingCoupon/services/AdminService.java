package tryingCoupons.tryingCoupon.services;

import tryingCoupons.tryingCoupon.beans.Company;
import tryingCoupons.tryingCoupon.beans.Coupon;
import tryingCoupons.tryingCoupon.beans.Customer;
import tryingCoupons.tryingCoupon.exceptions.CompanyException;
import tryingCoupons.tryingCoupon.exceptions.CustomerException;
import tryingCoupons.tryingCoupon.exceptions.LoginException;

import java.util.List;

public interface AdminService {
    /**
     * Adding company to data-base.
     * @param company - Getting Company object.
     * @throws CompanyException - if there's a problem with the Company object an exception will be thrown.
     */
    public void addCompany(Company company) throws CompanyException;

    /**
     * Update Company details.
     * @param company - Getting Company object.
     * @throws CompanyException -if there's a problem with the Company object an exception will be thrown.
     */
    public void updateCompany(Company company) throws CompanyException;

    /**
     * Delete company from data-base.
     * @param id - Getting an id of a company.
     * @throws CompanyException - Thrown if there is no such company.
     */
    public void deleteCompany(int id) throws CompanyException;

    /**
     * Getting list of all the companies.
     * @return - List of all companies.
     * @throws CompanyException - Will be thrown if there are no companies.
     */
    public List<Company> getAllCompanies() throws CompanyException;

    /**
     * Getting one company details by id.
     * @param id - Asking for an id of a company.
     * @return - Company.
     * @throws CompanyException - Will be thrown if company does not exist.
     */
    public Company getCompanyByID(int id) throws  CompanyException;

    /**
     * Adding customer to data-base.
     * @param customer - Getting a customer object to upload.
     * @throws CustomerException - Thrown if there is a problem with customer object
     */
    public void addCustomer(Customer customer) throws CustomerException;

    /**
     * Update a customer.
     * @param customer - Getting Customer object.
     * @throws CustomerException - Thrown if there's a problem with Customer object.
     */
    public void updateCustomer(Customer customer) throws CustomerException;

    /**
     * Deleting customer.
     * @param id - Getting customer ID.
     * @throws CustomerException - if there is no such customer.
     */
    public void deleteCustomer(int id) throws CustomerException;

    /**
     * Getting all customers that are exists.
     * @return - List of all customer.
     * @throws CustomerException - thrown if there are no Customers.
     */
    public List<Customer> getAllCustomer() throws CustomerException;

    /**
     * Getting one customer by id
     * @param id - Getting customer id
     * @return - Customer object
     * @throws CustomerException - Will be thrown if customer does not exist.
     */
    public Customer findCustomerById(int id) throws CustomerException;

    /**
     * Getting - All coupons that are available.
     * @return - List of all available coupons.
     */
    public List<Coupon> findAllAvailableCoupons();

    /**
     * Logout
     */
    public void logOut();

}
