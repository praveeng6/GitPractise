import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class GitDemo {
	public static Map<String, String> getData(String testdatafile, String sheetname, String testcaseid){
		
		
		Map<String, String> testdatainmap = new TreeMap<String, String>();
		String query = null;
		query = String.format("SELECT * FROM %s WHERE Run='Yes' and TESTCASEID='%s'" ,sheetname,testcaseid );
		Fillo fillo = new Fillo(); 
		Connection conn = null; 
		Recordset recordset = null;
		try{
			conn = fillo.getConnection(testdatafile);
			recordset = conn.executeQuery(query);
			while(recordset.next())
			{
				for(String field : recordset.getFieldNames())
				{
					testdatainmap.put(field, recordset.getField(field));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			 
		}
		
		conn.close();
		
		
		return testdatainmap;
		
		
		
		
		
		
		
		
	}

}

}
