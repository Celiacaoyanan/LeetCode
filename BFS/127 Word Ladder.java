// start from startword, pop out words from queue and for every word, get all the words that have only one char different with this word and must be in the dict, put them in the queue and set // note the location of steps++

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<String>();
        for (int i=0;i<wordList.size();i++) {
            dict.add(wordList.get(i));//set the use of add
        }
        
        if (beginWord.equals(endWord)) {//use of equals
            return 1;
        }
        
        Set<String> set=new HashSet<String>();
        Queue<String> queue=new LinkedList<String>();
        set.add(beginWord);
        queue.offer(beginWord);
        
        int steps=1;        
        while (!queue.isEmpty()) {
            steps++;
            int size=queue.size();
            for (int i=0;i<size;i++) {
                String word=queue.poll();
                List<String> candidate=new ArrayList<String>();
                candidate=similar(word,dict);
                for (int j=0;j<candidate.size();j++) {
                    if(candidate.get(j).equals(endWord)) {
                        return steps;
                    }
                    if (set.contains(candidate.get(j))) continue;
                    
                    set.add(candidate.get(j));
                    queue.offer(candidate.get(j));
                }
            }
        }
        
        return 0;

    }
    
    // get all the words that have only one char different with the give word and must be in the dict
    public List<String> similar(String w, Set<String> d) {
        List<String> simiWords=new ArrayList<String>();
        for (int k=0;k<w.length();k++) {// how to get the length of String
            for (char c='a';c<='z';c++) {
                if (w.charAt(k)==c) continue;
                String simiWord=replace(w,c,k);
                if (d.contains(simiWord)) {
                    simiWords.add(simiWord);
                }
            }
        }
        return simiWords;
    }
    
    
    public String replace(String w, char c, int index) {
        char[] tmp=w.toCharArray();// toCharArray() change string to char array
        tmp[index]=c;
        return new String(tmp); //change back to String
    }
    
    
}
