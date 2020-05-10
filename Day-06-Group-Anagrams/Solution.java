/**
 * Day 6 - Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example: 
 *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
 *  Output: [  ["ate","eat","tea"],  ["nat","tan"],  ["bat"] ]
 * 
 * Note: All inputs will be in lowercase. The order of your output does not matter.
 * 
 * Tip: HashMap
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs) {
            String sorted = Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(sorted, list);
            }   
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}