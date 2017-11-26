package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.sun.net.ssl.HttpsURLConnection;

import vo.ProductVo;

public class MySearchUtil {
	public static List<ProductVo> searchShop(String searchText, int start, int display){
		List<ProductVo> list = new ArrayList<>();
		
		String clientId ="uSUfms2pfxVNfIO_xX1k";
		String clientSecret = "W8q9JC8gkA";
		
		try {
			searchText = URLEncoder.encode(searchText, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					searchText, start, display);
			
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("X-Naver-Client_Id", clientId);
			conn.setRequestProperty("X-Naver-Client_Secret", clientSecret);
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.connect();
			
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(conn.getInputStream());
			Element root = document.getRootElement();
			System.out.println(root.getName()); // rss
			List<Element> elementList = (List<Element>)root.getChild("channel").getChildren("item");
			for(Element item : elementList) {
				String title = item.getChildText("title");
				String link = item.getChildText("link");
				String image = item.getChildText("image");
				int lprice = 0;
				int hprice =0;
				lprice = Integer.parseInt(item.getChildText("lprice"));
				hprice = Integer.parseInt(item.getChildText("hprice"));
				String mallName = item.getChildText("mallName");
				
				ProductVo vo = new ProductVo(title, link, image, lprice, hprice, mallName);
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
