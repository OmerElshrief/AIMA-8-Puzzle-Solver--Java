/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import ProblemFormulation.Node;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Omar
 */
public class SearchHelper
{
    
    
    
    
    private static SearchHelper searchHelper;

    private SearchHelper()
    {
        this.searchHelper=this;
    }
    
    public static SearchHelper getInstance()
    {
        if(searchHelper==null)
            return new SearchHelper();
                    else
            return searchHelper;
    }
    
    
    
    
    
    public boolean contains(List<Node> list , Node node)
     {
         for (int i=0;i<list.size();i++)
         {
             if(equal(list.get(i).getState() , node.getState()))
                 return true;
                         
         }
         return false;
         
     }
     
     public static boolean equal(final int[][] arr1, final int[][] arr2) {

 

  if (arr1 == null) {

 

 

return (arr2 == null);

 

  }

  if (arr2 == null) {

return false;
  }
  if (arr1.length != arr2.length) {

return false;
  }

  for (int i = 0; i < arr1.length; i++) {

if (!Arrays.equals(arr1[i], arr2[i])) {
return false;
}
 

  }

 

  return true;

    }
     
    
      public int[] getindex(int[][] state, int number)
     {
         for(int i=0;i<3;i++)
             for(int j=0;j<3;j++)
                 if(state[i][j]==number)
                 {
                     int [] index = {i,j};
                     return index;
                 }
         
         return null;
     }
      public int getAbsDifference(int x,int y)
      {
         return abs(x-y); 
      }
      
      public int getDifferenceSquare(int x, int y)
      {
          return (int) pow(getAbsDifference(x,y),2);
      }
      
      
      

}
