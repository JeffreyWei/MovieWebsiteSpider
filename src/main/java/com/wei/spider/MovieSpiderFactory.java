package com.wei.spider;

import com.wei.spider.worm.DY2018;

/**
 * Created by wei on 15/8/21.
 */
public class MovieSpiderFactory {
	public static MovieSpider feedSpider(String wormName) {
		MovieSpider movieSpider=null;
		if (wormName.equalsIgnoreCase("dy2018")) {
			movieSpider = new DY2018();
		}
		return movieSpider;
	}
}
