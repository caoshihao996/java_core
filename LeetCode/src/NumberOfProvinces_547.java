import org.junit.Test;

public class NumberOfProvinces_547 {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected[0].length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(isConnected[i][j]==1){
                    union(parent, i, j);
                }
            }
        }

        int res = 0;
        for(int i=0; i<n; i++){
            System.out.print(parent[i]+" ");
            if(parent[i]==i){
                res++;
            }
        }

        return res;
    }

    public void union(int[] parent, int index1, int index2){
        int find1 = find(parent, index1);
        int find2 = find(parent, index2);
        if(find1==find2){
            return;
        }
        parent[find1] = find2;
    }

    public int find(int[] parent, int index){
        if (parent[index]!=index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    @Test
    public void test(){
        int[][] is = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        System.out.println(findCircleNum(is));
    }

}
