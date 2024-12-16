class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = 0, n = 0;
        int[] result = new int[mat.length * mat[0].length];

        for(int i = 0; i < result.length; i++) {
            result[i] = mat[n][m];

            if((m+n) % 2 == 0) {
                if(m == mat[n].length - 1) {
                    n++;
                } else if(n == 0) {
                    m++;
                } else {
                    m++;
                    n--;
                }
            } else {
                if(n == mat.length - 1) {
                    m++;
                } else if(m == 0) {
                    n++;
                } else {
                    m--;
                    n++;
                }
            }
        }
        return result;
    }
}
