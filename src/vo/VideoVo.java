package vo;

import org.json.simple.JSONAware;

public class VideoVo implements JSONAware{
	private String title, path;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return "{'title':"+title+"','path':'"+path+"'}";
	}
	
	
}
