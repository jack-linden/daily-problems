package autocomplete;

import java.util.*;

/**
 * EfficientAutoCompleter
 */
public class EfficientAutoCompleter implements AutoCompleter {
    private Node dictionary;
    
    //O(N*k) where k is max length of a word
    public EfficientAutoCompleter(Set<String> words){
         this.dictionary = new Node('*', false);
         
         for(String word: words){
              int i = 0;
              Node curr = this.dictionary;
              do {
                  char c = word.charAt(i);
                  int index = c - 'a';
                  if( curr.next[index] == null ) curr.next[index] = new Node(c, false);
                  curr = curr.next[index];
              } while( ++i < word.length());
              curr.isWord = true;
         }
    }
    

    @Override
    public List<String> getCompletions(String prefix) {
      Node start = dictionary.atPrefix(prefix);
      if( start == null ){
        return new ArrayList<>();
      }
      List<String> results = new ArrayList<>();
      traverse(start, new StringBuilder(prefix), results);

      return results;
    }

    private void traverse(Node curr, StringBuilder builder, List<String> found){
        if(curr.isWord){
          found.add(builder.toString());
        }

        for(Node n : curr.next){
          if( n != null){
            builder.append(n.c);
            traverse(n, builder, found);
            builder.deleteCharAt(builder.length()-1);
          }
        }
    }



    class Node {
        public char c;
        public Node[] next;
        boolean isWord;

        public Node(char c, boolean isWord){
            this.next = new Node[26];
	          this.c = c;
            this.isWord = isWord;
        }

        public Node atPrefix(String prefix){
          Node curr = this;
          for( int i =0; i < prefix.length(); i++ ){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if( curr.next[index] == null ) return null;
            curr = curr.next[index];
          }

          return curr; 
        }
    }

}
