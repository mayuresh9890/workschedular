package controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/workschedular")
public class ResourceController {
	
	@Autowired  
    JdbcTemplate jdbc; 
	
	@RequestMapping(value="/getData",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Map<String, Object>> getData(@RequestParam(value="qry") String sql) {
		return jdbc.queryForList(sql);
	}
	
	@RequestMapping(value="/saveData",produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, String> saveData(@RequestParam(value="query") String sql) throws DataAccessException {
		HashMap<String,String> map = new HashMap<>();	
		String c_ReturnData = (jdbc.update(sql) >= 1) ? "true" : "false";
		map.put("result", c_ReturnData);
		System.out.println("c_ReturnData : " +c_ReturnData);
		return map;
	}
}
