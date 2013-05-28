/**
 * Collects all the links on a webpage
 * @author Andrew Knapp
 *
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class grabLinks {
	static errorLog elog;
	
	public grabLinks() {
		elog = new errorLog();
	}
	
	/**
	 * Parses out links from a webpage using JSoup parser.
	 * @param url the given URL
	 * @return linkCache Set
	 */
	public static Set<String> getLinks(String url){
		Set<String> linkCache = new HashSet<String>();
		try{
			Document page = Jsoup.connect(url).get();
			Elements listLinks = page.select("a[href]");
			for(Element link : listLinks){
				linkCache.add(link.attr("abs:href"));
			}
		} catch (IOException e){
			elog.writeLog("Error Processing: " + url);
		} catch (IllegalArgumentException ae){
			elog.writeLog("Error Processing: " + url);
		}
		return  linkCache;
	}
	
}
