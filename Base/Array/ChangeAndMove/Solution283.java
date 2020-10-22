package com.company.Base.Array.ChangeAndMove;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int numLast = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0 && i < numLast) {
                for (int j = i + 1; j <= numLast; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[numLast] = 0;
                numLast = numLast - 1;
                i--;
            }
        }
    }

    /**
     * 官方解法：双指针
     * @param nums
     */
    public void moveZeroes2(int[] nums) {

        int j=0;
        //找出不为0的数字,并移到最左边的位置,j+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        //剩下位置都是0
        while(j<nums.length){
            nums[j]=0;
            j++;
        }
    }

    /**
     * 官方解法：最优解
     *      前一种方法的操作是局部优化的。例如，所有（除最后一个）前导零的数组：[0，0，0，…，0，1]。对数组执行多少写操作？
     * 对于前面的方法，它写 0 n-1n−1 次，这是不必要的。我们本可以只写一次。怎么用？… 只需固定非 0 元素。
     *
     *      最优方法也是上述解决方案的一个细微扩展。一个简单的实现是，如果当前元素是非 0 的，那么它的正确位置最多可以是当前
     * 位置或者更早的位置。如果是后者，则当前位置最终将被非 0 或 0 占据，该非 0 或 0 位于大于 “cur” 索引的索引处。我们马上
     * 用 0 填充当前位置，这样不像以前的解决方案，我们不需要在下一个迭代中回到这里。
     *
     * 换句话说，代码将保持以下不变：
     *      慢指针（lastnonzerofoundat）之前的所有元素都是非零的。
     *      当前指针和慢速指针之间的所有元素都是零。
     * 因此，当我们遇到一个非零元素时，我们需要交换当前指针和慢速指针指向的元素，然后前进两个指针。如果它是零元素，我们只前进当前
     * 指针。
     * @param nums
     */
    public void moveZeroes3(int[] nums) {

        for(int i = 0,j = 0; i < nums.length; i++ ){
            if(nums[i] != 0){
                if(nums[j] == 0){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                ++j;
            }
        }
    }
}
