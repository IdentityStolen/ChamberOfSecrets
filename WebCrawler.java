/**
 * 
 */
package com.godad;

import java.util.*;
import java.io.IOException;
import java.net.*;

/**
 * @author SK030960
 *
 */
public class WebCrawler {

	/**
	 * @param args
	 */
	private String url;
	public static final String startOfUrl = "href=\"";
	public static final String endOfUrl = "\"";
	public static final int len = startOfUrl.length();
	
	public WebCrawler(String url) {
		this.url = url;
	}
	
	public String getSeedUrl() {
		return this.url;
	}
	
	public Set<String> getUrls(){
		Queue<URL> queue = new LinkedList<>();
		Set<String> uniqueUrls = new HashSet<>();
		
		try {
			URL url = new URL(this.getSeedUrl());
			queue.offer(url);
			Scanner sc = null; 
			String line = null;
			while(!queue.isEmpty()) {
				url = queue.poll();
				uniqueUrls.add(url.toString());
				System.out.println(url.toString());
				sc = new Scanner(url.openStream());
				line = sc.nextLine();
				while(sc.hasNextLine()) {
					int startIndex = line.indexOf(startOfUrl);
					while (startIndex != -1) {
						startIndex = startIndex + len;
						int endIndex = line.indexOf(endOfUrl, startIndex);
						String link = line.substring(startIndex, endIndex);
						if (!uniqueUrls.contains(link)) {
							if (link.indexOf("http") != -1) {	//validating a url is an issue, once url is malformed, program stops
								url = new URL(link);
								queue.offer(url);
							}
						}
						startIndex = line.indexOf(startOfUrl, startIndex);
					}
					line = sc.nextLine();
				}
			}
			return uniqueUrls;
		} catch (MalformedURLException e) {
//			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebCrawler link = new WebCrawler("https://en.wikipedia.org/wiki/Encyclopedia");
		Set<String> urls = new HashSet<>();
		urls = link.getUrls();
	}

}
