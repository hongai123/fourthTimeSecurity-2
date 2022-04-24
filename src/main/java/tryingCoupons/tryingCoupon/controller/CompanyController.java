package tryingCoupons.tryingCoupon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tryingCoupons.tryingCoupon.beans.Company;
import tryingCoupons.tryingCoupon.beans.Coupon;
import tryingCoupons.tryingCoupon.exceptions.*;
import tryingCoupons.tryingCoupon.services.CompanyServiceMPL;
import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyServiceMPL companyServiceMPL;
//
//    @PostMapping("/login/{email}/{password}")
//    public void login(@PathVariable String email, @PathVariable String password) throws LoginException {
//        companyServiceMPL.login(email,password);
//    }

    /**
     * Adding coupon.
     * @param coupon - Getting coupon object
     * @throws CouponOutOfAmountException - Will be thrown if coupon amount is less than 1.
     * @throws CouponException - Will be thrown if there's a problem with the Coupon object
     * @throws CouponExpiredException - Will be thrown if the coupon is initialized with expired date.
     * @throws CompanyException - Will be thrown if Company already holding this coupon.
     */
    @PostMapping("addCoupon")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addCoupon(@RequestBody Coupon coupon) throws CouponOutOfAmountException, CouponException, CouponExpiredException, CompanyException {
        companyServiceMPL.addCoupon(coupon);
    }

    /**
     * Update a coupon.
     * @param coupon - Getting Coupon object with updated details.
     * @throws CouponException - Will be thrown if there is a problem with the coupon object.
     */
    @PutMapping("/updateCoupon")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCoupon(@RequestBody Coupon coupon) throws CouponException {
        companyServiceMPL.updateCoupon(coupon);
    }

    /**
     * Deleting coupon.
     * @param id - Getting coupon id.
     * @throws CouponException - Will be thrown if the coupon does not exist.
     */
    @DeleteMapping("/deleteCoupon/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCoupon(@PathVariable int id ) throws CouponException {
        companyServiceMPL.deleteCoupon(id);
    }


    /**
     * Getting coupons that belongs to the company.
     * @return -  List of Coupon object.
     * @throws CouponException - will be thrown if there are no coupons.
     */
    @GetMapping("/allCompanyCoupon")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> allCompanyCoupons() throws CouponException {
        return companyServiceMPL.getAllCompanyCoupons();
    }

    /**
     * Getting Company coupons By category
     * @param categoryID -Getting the category id
     * @return List of coupons with the exact category that the user chose.
     * @throws CouponException - Will be thrown if there are no such coupons.
     */
    @GetMapping("/companyCategory/{categoryID}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> companyCouponByCategory(@PathVariable int categoryID) throws CouponException {
        return companyServiceMPL.companyCouponsByCategory(categoryID);
    }

    /**
     * Getting coupons by max price.
     * @param price - The max price that we choose.
     * @return - List of coupons with that max priced.
     * @throws CouponException -  Will be thrown if there are no coupons with this max price.
     */
    @GetMapping("/companyCategoryMaxPrice/{price}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> companyCouponsByMaxPrice(@PathVariable int price) throws CouponException {
        return companyServiceMPL.companyCouponsByMaxPrice(price);
    }

    /**
     * Getting company details
     * @return - Company object with the current company values
     * @throws LoginException -  Will be thrown if the user is not logged.
     */
    @GetMapping("/getCompanyDetails")
    @ResponseStatus(HttpStatus.OK)
    public Company companyDetails() throws LoginException {
        return companyServiceMPL.companyDetails();
    }

}
