package com.example.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingData {

	private Document doc;
	
	public CrawlingData() {

	}
	
	public CrawlingData(String url){
		
		try {
			doc = Jsoup.connect(url)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36")  
					.referrer("http://www.google.com")
					.get();
			
			String title = doc.title();
			System.out.println("title> " + title);
			
			Elements elements = doc.select("a[href]");
			
			for(Element e : elements){
				System.out.println("e> " + e.toString());
				System.out.println("text : " + e.text());
				System.out.println("link : " + e.attr("href"));
				System.out.println("\n");
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("CrawlingData error> " + e);
		}
		
		
	}
}
