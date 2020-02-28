/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package max;

import java.util.*;

public class MaxSubArrayValsOfLenK {
    
    // O(n*(n-k)) = O(n^2) runtime O(k) space
    public List<Integer> solveQuadratic(int[] arr, int k){

        List<Integer> response = new ArrayList<>();

        for( int i = 0 ; i <= arr.length - k; i++ ){
            int max = arr[i];
            for( int j = i + 1; j < i + k; j++ ){
                max = arr[j] > max ? arr[j] : max;
            }
            response.add(max);
        }

        return response;
    }
}      

