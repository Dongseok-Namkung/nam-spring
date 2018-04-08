package com.nkds.web.controller.handler;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nkds.common.util.ObjectUtil;
import com.nkds.web.dto.AbstractDTO;


@Component
public class ResponseHandler {
	public <RM, RT extends AbstractDTO> ResponseEntity<?> flushResponse(RM model, Class<RT> dtoClass){
		
		if(ObjectUtil.isEmpty(model)) {
			return new ResponseEntity<AbstractDTO>(new AbstractDTO().setHttpStatus(HttpStatus.NOT_FOUND)
													,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<RT>((RT) new ModelMapper().map(model, dtoClass), HttpStatus.OK);
	}
}
