package com.nkds.web.controller.handler;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.nkds.web.dto.AbstractDTO;


@Component
public class ResponseHandler {
	public <RM, RT extends AbstractDTO> ResponseEntity<?> flushResponse(RM model, Class<RT> dtoClass){
		
		if(model == null) {
			return new ResponseEntity<AbstractDTO>(new AbstractDTO()
														.setHttpStatus(HttpStatus.NOT_FOUND)
														.setResult(null)
													,HttpStatus.NOT_FOUND);
		}
		
		RT dto = (RT) new ModelMapper().map(model, dtoClass);
		
		return new ResponseEntity<RT>(dto, HttpStatus.OK);
	}
}
