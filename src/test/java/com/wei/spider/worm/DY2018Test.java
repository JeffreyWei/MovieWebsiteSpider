package com.wei.spider.worm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wei.spider.entity.MovieInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wei on 15/8/23.
 */
public class DY2018Test {
	@Test
	public void selectMovieDataTest() {
		try {
			List<MovieInfo> movieInfos = JSON.parseObject(FileUtils.readFileToString(new File("/Users/wei/work/code/java/MovieWebsiteSpider/data/dy2018/data.json"), "UTF-8"), new TypeReference<List<MovieInfo>>() {});
			final List<MovieInfo> reuslt = new ArrayList<MovieInfo>();
			movieInfos.forEach(info -> {
				try {
					if (info.getRank()>7){
						reuslt.add(info);
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			});
			for (MovieInfo info : reuslt) {
				System.out.println(info.toString());
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}