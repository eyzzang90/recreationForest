package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.common.CrawlingData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/templates/context/context-mongo.xml")
public class CrawlingTest {

	@Test
	public void test(){
		
		String url = "https://www.google.co.kr/?gfe_rd=cr&ei=efjFWI_BKK6L8Qe8nZawBA#q=%ED%9C%B4%EC%96%91%EB%A6%BC&*";
		
		CrawlingData crawl = new CrawlingData(url);
		
	}

}
