import org.junit.Test;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int res = 0;
        int length = flowerbed.length;
        if(length==1 && flowerbed[0]==0 && n<=1){
            return true;
        }

        for(int i=0; i<length; i++){

            if(flowerbed[i]==0){
                if(i==0 && i+1<length &&flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    res++;
                }else if(i==length-1 && i-1>0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    res++;
                }else  if(i+1<length && i>0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    res++;
                }
            }

        }
        System.out.println(res);
        return res>=n;
    }

    @Test
    public void test(){
        System.out.println(canPlaceFlowers(new int[]{0}, 1));
    }
}
