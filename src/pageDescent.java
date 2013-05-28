import java.util.HashSet;
import java.util.Set;

/**
 * Class containing a recursive method to crawl through a website identifying content
 * saving those files that it identifies as such, and continuing to decend links on web
 * pages until it hits it's given maximun hops.
 * @author Andrew Knapp
 *
 */
public class pageDescent {
	
	private static Set<String> linkHolder;
	private static Set<String> fileTypes;
	private static String setContents[] = {"jpg", "png", "wmv", "mov", "mpeg", "jpeg",
		"mp4","avi", "ram", "rm", "rmvb", "mpg"}; // TODO: Add selection option to view
	private static String downloadDirectory; // TODO: Add Option for this to view
	
	/**
	 * Constructor
	 */
	public pageDescent(String initalURL, int maxHops){
		fileTypes = populateSet(setContents);
		downloadDirectory = ".";
		descendPages(initalURL, maxHops);
	}
	
	/**
	 * Recursive method that crawls through websites grabbing links,
	 * determines if they are content, downloading, continuing to crawl if they
	 * aren't content
	 * @param url root URL
	 * @param descent depth to decend
	 * @return
	 */
	public static void descendPages(String rootURL, int descent){
		linkHolder = grabLinks.getLinks(rootURL);
		for(String link: linkHolder){
			if (identifyContent(link)){
				String fileName = link.substring(link.lastIndexOf("/") + 1, link.length());
				contentDownloader content = new contentDownloader();
				content.downloadContent(link, fileName);
			} else {
				if (descent > 1){
					descendPages(link, descent - 1);
				}
	
			}
		}
	}
	
	/**
	 * Determine if a URL is content by looking at filetype extension
	 * @param url
	 * @return boolean
	 */
	private static boolean identifyContent(String url){
		String ext = url.substring((url.lastIndexOf(".") + 1), url.length());
		if (fileTypes.contains(ext.toLowerCase())){
			return true;
		}
		return false;
	}
	
	/**
	 * Private method to populate a filetype set
	 * @return
	 */
	private static Set<String> populateSet(String contents[]){
		Set<String> fileTypes = new HashSet<String>();
		for(String item : contents){
			fileTypes.add(item);
		}
		return fileTypes;
	}
}

