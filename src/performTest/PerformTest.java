package performTest;

import java.util.HashMap;
import java.util.Map;

public class PerformTest {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("test", 0);
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 999999999; i++){
			map.put("test",map.get("test") + 1);
		}
		System.out.println(System.currentTimeMillis()-startTime);
		startTime =System.currentTimeMillis();
		map.put("test",0);
		int[] num = {0};
		for(int i = 0; i < 999999999; i++){
			num[map.get("test")]++;
		}
		System.out.println(System.currentTimeMillis()-startTime);
	}
}
