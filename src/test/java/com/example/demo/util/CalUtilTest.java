package com.example.demo.util;

import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.util.CustomCalendarUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalUtilTest {	
	
	@Test
	public void currCal() {
		
		for(int i = 3 ; i < 12 ; i++ ) {
			Map<String, Integer> hm = CustomCalendarUtil.getCurrentCalendarInfo(2019, i, 1);
			
			Iterator<?> it = hm.keySet().iterator();
			while(it.hasNext()) {
				String k = it.next() + "";
				System.out.println("k:" + k +", v:" + hm.get(k));
			}
		}		
	}
	
	@Test
	public void dayOfWeekTest() {
		for(int i = 1 ; i < 25 ; i++ ) {
			Map<String, Integer> hm = CustomCalendarUtil.getCurrentCalendarInfo(2019, 10, i);
			
			Iterator<?> it = hm.keySet().iterator();
			while(it.hasNext()) {
				String k = it.next() + "";
				System.out.println("k:" + k +", v:" + hm.get(k));
			}
		}	
	}
}
