package com.wei.spider;

import com.wei.spider.entity.MovieInfo;

import java.util.List;

/**
 * Created by wei on 15/8/21.
 */
public interface MovieSpider {
	/**
	 * 获取电影列表
	 * @return
	 */
	List<MovieInfo> getMovies();

	/**
	 * 获取来源信息
	 * @return
	 */
	String getOriginType();

}
