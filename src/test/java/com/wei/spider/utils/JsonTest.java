package com.wei.spider.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wei.spider.entity.MovieInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import sun.security.action.PutAllAction;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wei on 15/8/23.
 */
public class JsonTest {
	@Test
	public void jsonTest() {
		MovieInfo movieInfo_0 = new MovieInfo("测试影片1","http://www.test.com");
		MovieInfo movieInfo_1 = new MovieInfo("测试影片2","http://www.test.org");
		List<MovieInfo> movieInfos=new ArrayList<MovieInfo>() {
			{
				add(movieInfo_0);
				add(movieInfo_1);
			}
		};
		try {
			FileUtils.writeStringToFile(new File("/Users/wei/work/code/java/MovieWebsiteSpider/src/test/java/com/wei/spider/utils/testdata"), JSON.toJSONString(movieInfos), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			List<MovieInfo> targetInfos = JSON.parseObject(FileUtils.readFileToString(new File("/Users/wei/work/code/java/MovieWebsiteSpider/src/test/java/com/wei/spider/utils/testdata"), "UTF-8"), new TypeReference<List<MovieInfo>>() {});
			assertThat(movieInfo_0.getMovieName(), is(targetInfos.get(0).getMovieName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jsonEntityTest() {
		MovieInfo movieInfo = new MovieInfo("测试影片1","http://www.test.com");
		try {
			FileUtils.writeStringToFile(new File("/Users/wei/work/code/java/MovieWebsiteSpider/src/test/java/com/wei/spider/utils/testdata1"), JSON.toJSONString(movieInfo), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			MovieInfo targetInfo = (MovieInfo) JSON.parseObject(FileUtils.readFileToString(new File("/Users/wei/work/code/java/MovieWebsiteSpider/src/test/java/com/wei/spider/utils/testdata1"), "UTF-8"), MovieInfo.class);
			assertThat(movieInfo.getMovieName(), is(targetInfo.getMovieName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
