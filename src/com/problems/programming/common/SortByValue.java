package com.problems.programming.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortByValue {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(set);
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> arg0,Map.Entry<String, Integer>  arg1) {
				return arg0.getValue().compareTo(arg1.getValue());
			}
		});
        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
	}

}
