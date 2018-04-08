package com.nkds.common.util;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.nkds.web.dto.AbstractDTO;

public class ObjectUtil {
	
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object object) {
		boolean isEmpty = false;
		
		if(object == null) {
			return true;
		}
		
		if(object instanceof AbstractDTO) {
			
		} else if (object instanceof ResponseEntity) {
			object = (ResponseEntity) object;
			
			return ((ResponseEntity) object).hasBody();
		} else if (object instanceof List) {
			object = (List) object;
			
			return ((List) object).isEmpty();
		}
		
		
		return isEmpty;
	}
	
}
