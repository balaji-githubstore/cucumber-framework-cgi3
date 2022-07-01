import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1 {
	
	public static void main(String[] args) {
		
		Map<String, String> row1=new HashMap<String, String>();
		row1.put("contactname", "peter");
		row1.put("relationship", "brother");
		row1.put("mobile", "8878877");
		row1.put("mobile", "4");
		
		System.out.println(row1.get("contactname"));
		System.out.println(row1.get("mobile"));
		
		
		Map<String, String> row2=new HashMap<String, String>();
		row2.put("contactname", "mark");
		row2.put("relationship", "brother");
		row2.put("mobile", "9999");

		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		
		list.add(row1);
		list.add(row2);
		
		System.out.println(list.get(0).get("contactname"));
		
	}

}
