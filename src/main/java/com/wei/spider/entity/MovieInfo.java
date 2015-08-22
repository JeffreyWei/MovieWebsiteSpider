package com.wei.spider.entity;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 影片实体类
 * Created by wei on 15/8/21.
 */
public class MovieInfo {
	private static Pattern pattern = Pattern.compile("《(.*?)》");
	private String movieName;//电影名称
	private String movieType;//电影类型
	private Date updateTime;//数据更新时间
	private String webTitle;//页面标题
	private String webURL;//页面链接
	private String originType;//来源
	private String downloadURL;//电影下载地址
	private double rank;//电影得分

	public MovieInfo(String webTitle, String webURL) {
		this.webTitle = webTitle;
		this.webURL = webURL;
		this.updateTime = new Date();
		this.movieName = webTitle;
		Matcher matcher = pattern.matcher(webTitle);
		while (matcher.find()) {
			movieName = matcher.group(1);
			break;
		}
	}

	@Override
	public String toString() {
		return "MovieInfo{" +
				"movieName='" + movieName + '\'' +
				", movieType='" + movieType + '\'' +
				", updateTime=" + updateTime +
				", webTitle='" + webTitle + '\'' +
				", webURL='" + webURL + '\'' +
				", originType='" + originType + '\'' +
				", downloadURL='" + downloadURL + '\'' +
				", rank=" + rank +
				'}';
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getWebTitle() {
		return webTitle;
	}

	public void setWebTitle(String webTitle) {
		this.webTitle = webTitle;
	}

	public String getWebURL() {
		return webURL;
	}

	public void setWebURL(String webURL) {
		this.webURL = webURL;
	}

	public String getOriginType() {
		return originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	public String getDownloadURL() {
		return downloadURL;
	}

	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
}
