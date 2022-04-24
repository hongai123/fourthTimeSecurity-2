package tryingCoupons.tryingCoupon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tryingCoupons.tryingCoupon.beans.UserProp;
import tryingCoupons.tryingCoupon.exceptions.LoginException;
import tryingCoupons.tryingCoupon.services.AdminServicesService;
import tryingCoupons.tryingCoupon.services.CompanyServiceMPL;
import tryingCoupons.tryingCoupon.services.CustomerServiceMPL;

@RestController
@RequestMapping("/token")
//@CrossOrigin
@RequiredArgsConstructor
/**
 * login/token/logout controller
 */
public class GetTokenController {
    private final CompanyServiceMPL companyServiceMPL;
    private final CustomerServiceMPL customerServiceMPL;
    private final AdminServicesService adminServicesMPL;

    /**
     * Getting token of logged user from header.
     * @return - Response entity which contains the token.
     * @throws LoginException - If user is not logged this exception will be thrown.
     */
    @GetMapping("/getToken")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> getToken() throws LoginException {
        HttpHeaders responseHeader =  new HttpHeaders();

        if(adminServicesMPL.isLogged()){
            responseHeader.set("Token","Bearer "+adminServicesMPL.getToken());
            //return "Bearer " + adminServicesMPL.getToken();
            return ResponseEntity.accepted()
                    .headers(responseHeader)
                    .body("your token is in the headers!");
        }

        if(companyServiceMPL.isLogged()){
            responseHeader.set("Token","Bearer "+companyServiceMPL.getToken());
            //return "Bearer " + companyServiceMPL.getToken();
            return ResponseEntity.accepted()
                    .headers(responseHeader)
                    .body("your token is in the headers!");
        }

        if(customerServiceMPL.isLogged()){
            responseHeader.set("Token","Bearer "+customerServiceMPL.getToken());
            //return "Bearer " + customerServiceMPL.getToken();
            return ResponseEntity.accepted()
                    .headers(responseHeader)
                    .body("your token is in the headers!");
        }

        else{
            throw new LoginException("Please log in first!");
        }
    }


    /**
     * Logout
     * @return - ModelAndView Object which redirect browser to a specific route.
     * @throws LoginException - If the user is not logged this exception will be thrown.
     */
    @RequestMapping(value = "/lognout", method = RequestMethod.GET)
    public ModelAndView logOut() throws LoginException {
        if(adminServicesMPL.isLogged()){
            adminServicesMPL.logOut();
            System.out.println("in admin logout");
            return new ModelAndView("redirect:" + "http://localhost:8080/login");
        }

        if(companyServiceMPL.isLogged()){
            companyServiceMPL.logOut();
            System.out.println("in company log out");
            return new ModelAndView("redirect:" + "http://localhost:8080/login");
        }

        if(customerServiceMPL.isLogged()){
            customerServiceMPL.logOut();
            System.out.println("in customer log out");
            return new ModelAndView("redirect:" + "http://localhost:8080/login");
        }

        else{
            throw new LoginException("Please log in first!");

        }
    }

    /**
     * Login with controller
     * @param user - User object which contains username and password.
     * @return - boolean if logged.
     * @throws LoginException - Will be thrown if username or password are invalid.
     */
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> log(@RequestBody UserProp user) throws LoginException {
        System.out.println(user);
        if(adminServicesMPL.login(user.getUsername(),user.getPassword())){
            System.out.println("im here :)");
            return getToken();
        }
        else if(companyServiceMPL.login(user.getUsername(), user.getPassword())){
            return getToken();
        }
        else if(customerServiceMPL.login(user.getUsername(), user.getPassword())){
            return getToken();
        }
        else{
            throw new LoginException("wrong username or password");
        }

    }

}
