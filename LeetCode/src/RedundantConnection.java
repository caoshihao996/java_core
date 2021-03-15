import org.junit.Test;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i]=i;
        }

        for(int[] edge : edges){
            if(find(parent, edge[0])==find(parent, edge[1])){
                return edge;
            }else{
                union(parent, edge[0], edge[1]);
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int x){
        int index = x;
        while(parent[index]!=index){
            index = parent[index];
        }
        return index;
    }

    @Test
    public void test(){
        int[][] arr= new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] res = findRedundantConnection(arr);
        System.out.println(res[0]+" "+res[1]);
    }
}
