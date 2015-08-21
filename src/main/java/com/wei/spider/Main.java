package com.wei.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by wei on 15/8/21.
 */
public class Main {
	public static void main(String[] args) {
		Document doc= Jsoup.parse("www.baidu.com");
		System.out.println(doc.html());
	}
}
