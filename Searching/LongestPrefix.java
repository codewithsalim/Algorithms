public String getMatchingPrefix(String input)  {
        String result = ""; 
        int length = input.length();      
        TrieNode curr = root;   
  
        int prevMatch = 0;
        for( int i = 0 ; i < length; i++ )  {
          char ch = input.charAt(level);    
            if( curr.children[c - 'a'] != null ) {
               result += ch;
               curr = curr.children[c - 'a'];
              
               if( curr.isWord )
                    prevMatch = i + 1;
            }
            else  break;
        }
  
        if( !curr.isWord )
          return result.substring(0, prevMatch);        
  
        else return result;
    }
