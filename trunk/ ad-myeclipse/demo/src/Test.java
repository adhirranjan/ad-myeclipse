import java.io.IOException;

import ad.json.me.JSONArray;
import ad.json.me.JSONException;
import ad.json.me.JSONObject;
import ad.json.me.JSONObjectFactory;


public class Test {
	public static void main(String[] args) throws IOException, JSONException {
		String jsonString ="";// "{'customer':{'rows':[{'name':'SEVA  SAMITI'}]},'account':{'rows':[{'accountnumberfordisplay':'1002L0014001051'},{'accountnumberfordisplay':'1002L0021007068'},{'accountnumberfordisplay':'1002L0021007069'},{'accountnumberfordisplay':'1002L0021007070'},{'accountnumberfordisplay':'1002L0021007130'},{'accountnumberfordisplay':'1002L0021007731'},{'accountnumberfordisplay':'1002L0021007802'}]}}";
		jsonString = "{'orgelementid':'123','agentid':'12345','agent_code':'7894',agent_name:'" + "name of agent" + "'}";
		
		System.out.println("-----------------------");
		
		System.out.println(jsonString);
		
		JSONObject jObj=new JSONObject();
		jObj= JSONObjectFactory.GetJSONObject(jsonString, "\"");
		
		System.out.println(jObj.getString("orgelementid"));
		
//		JSONObject jCustomer= (JSONObject) jObj.get("customer");
//		System.out.println(((JSONObject) jCustomer.getJSONArray("rows").getJSONObject(0)).getString("name"));
//		
//		
//		JSONObject jTable = (JSONObject) jObj.get("account");
//		
//		System.out.println(jTable.toString());
//		
//		JSONArray jRows = jTable.getJSONArray("rows");
//		for(int i=0;i<jRows.length()-1;i++){
//			JSONObject jRow = (JSONObject) jRows.get(i);
//			
//			System.out.println(i + "--" +  jRow.getString("accountnumberfordisplay"));
//		}
	
		System.in.read();
	}
}
