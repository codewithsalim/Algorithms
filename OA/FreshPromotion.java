/*
Example 1:

Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
Output: 1

*/
public boolean isWinner(List<List<String>> proList, List<String> order) {
        int ordInd=0, proLsInd=0;

        while(ordInd < order.size() && proLsInd < proList.size() ){

            List<String> pListItem=proList.get(proLsInd);
            int proLsItemind=0;
            while(proLsItemind < pListItem.size() && ordInd < order.size()){
                if(pListItem.get(proLsItemind).equals(order.get(ordInd)) || pListItem.get(proLsItemind).equals("anything")){
                    proLsItemind ++;
                }else{
                    proLsItemind=0;
                }
                ordInd++;
            }
            if(proLsItemind != pListItem.size())
                return false;

            proLsInd++;
        }

        if(proLsInd < proList.size())
            return false;

        return true;
    }
