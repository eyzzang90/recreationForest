package com.example.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.RecreationForest;
import com.example.repository.RecreationForestRepository;

@Controller
public class RecreationForestController {

	@Autowired
	RecreationForestRepository recreationForestRepository;
	
	@RequestMapping("/list")
	public String list(Model model, HttpServletRequest request, @ModelAttribute RecreationForest rcrFrst, 
			@PageableDefault(page=0, size=10, direction=Direction.ASC, sort={"name", "id"}) Pageable pageable){
		
		System.out.println("pageSize> " + pageable.getPageSize());
		System.out.println("getPageNumber> " + pageable.getPageNumber());
		System.out.println("getSort> " + pageable.getSort());
		
		System.out.println("페이지 호출");
		Page<RecreationForest> list =  recreationForestRepository.findByCpCode(rcrFrst.getCpCode(), pageable);
		
		if(list ==null){
			System.out.println("null");
		}else{
			for(RecreationForest recreationForest : list){
				System.out.println(recreationForest.toString());
			}
		}
		model.addAttribute("list", list);
		
		return "list";
	}
}
