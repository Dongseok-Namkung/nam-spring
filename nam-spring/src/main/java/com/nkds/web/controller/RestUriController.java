package com.nkds.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nkds.web.model.User;
import com.nkds.web.service.UserService;

@RestController
@RequestMapping(value = "/rest")
public class RestUriController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestUriController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/{stfno}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(@PathVariable("stfno") String stfno) {
		
        User user = userService.getUserInfo(stfno);
        
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

	
}
