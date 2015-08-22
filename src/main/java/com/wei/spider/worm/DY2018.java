package com.wei.spider.worm;

import com.wei.spider.MovieSpider;
import com.wei.spider.entity.MovieInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wei on 15/8/21.
 */
public class DY2018 implements MovieSpider {
	private static final String DY2018 = "http://www.dy2018.com/i/";
	private static final String ORIGINTYPE = "dy2018";
	private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

	public List<MovieInfo> getMovies() {
		final List<MovieInfo> MovieInfos = Collections.synchronizedList(new ArrayList<MovieInfo>());
		for (int i = 91606; i < 98000; i++) {
			final URL weburl;
			final String pageNum = String.valueOf(i) + ".html";
			try {
				weburl = new URL(DY2018 + pageNum);
			} catch (MalformedURLException e) {
				continue;
			}
			pool.execute(new Runnable() {
				public void run() {
					try {
						Document doc = Jsoup.parse(weburl, 3000);
						MovieInfo movieInfo = new MovieInfo(doc.title().trim(), weburl.toString());
						movieInfo.setUpdateTime(new Date());
						Elements position = doc.select(".position");
						try {
							movieInfo.setRank(Double.parseDouble(position.select("strong").first().text().trim()));
						} catch (Exception e) {
						}
						try {
							movieInfo.setMovieType(position.select("span").get(1).text().replace("类型：", "").trim());
						} catch (Exception e) {
						}
						try {
							movieInfo.setRank(Double.parseDouble(position.select("strong").first().text().trim()));
						} catch (Exception e) {
						}
						try {
							Element a = doc.select("font[color=#0c9000] a").get(0);
							movieInfo.setDownloadURL(a.text().trim());
						} catch (Exception e) {
						}
						movieInfo.setOriginType(ORIGINTYPE);
						MovieInfos.add(movieInfo);
						System.out.println(pageNum + "获取成功");
					} catch (IOException e) {
						System.out.println(pageNum + "获取失败");
					}
				}
			});

		}
		pool.shutdown();
		while (!pool.isTerminated()) {
			try {
				pool.awaitTermination(1, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("========end=======");
		return MovieInfos;
	}
}
