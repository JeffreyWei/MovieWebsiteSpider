package com.wei.spider;

/**
 * Created by wei on 15/8/21.
 */
public class Main {
	public static void main(String[] args) {
		if (args.length == 0) {
			return;
		}
		MovieSpider movieSpider = MovieSpiderFactory.feedSpider(args[0]);
		movieSpider.getMovies();
	}
}
