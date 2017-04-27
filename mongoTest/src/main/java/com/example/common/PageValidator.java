package com.example.common;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.domain.Page;

public class PageValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Page.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Page page = (Page)target;
		
		if(page.getPageNo()<0){
			page.setPageNo(0);
			errors.rejectValue("pageNo", "page.pageNo");
		}else{

		}
		
		if(page.getPageSize()<10){
			errors.reject("pageSize", "page.pageSize");
			errors.rejectValue("pageSize", "page.pageSize");
			page.setPageSize(10);
		}else if(page.getPageSize()>50){
			errors.reject("pageSize", "page.pageSize");
			errors.rejectValue("pageSize", "page.pageSize");
			page.setPageSize(50);
		}
		
		//sortDirection
		if(page.getSortDirection().trim().isEmpty() || page.getSortDirection() == null){
			errors.reject("sortDirection", "page.sortDirection");
			errors.rejectValue("sortDirection", "page.sortDirection");
			page.setSortDirection("A");
			page.setDirection(Direction.ASC);
		}else{
			if(page.getSortDirection().equals("D")){
				page.setSortDirection("D");
				page.setDirection(Direction.DESC);
			}else if(page.getSortDirection().equals("A")){
				page.setSortDirection("A");
				page.setDirection(Direction.ASC);
			}else{
				errors.reject("sortDirection", "page.sortDirection");
				errors.rejectValue("sortDirection", "page.sortDirection");
				page.setSortDirection("A");
				page.setDirection(Direction.ASC);
			}
		}
		
	
		
	}

}
