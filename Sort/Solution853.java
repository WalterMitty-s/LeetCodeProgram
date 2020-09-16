package com.company.Sort;

import java.util.Arrays;

public class Solution853 {
    /**
     * 根据题解完成
     * 解答步骤：
     *      1,创建（postion，speed）对象car
     *      2.对car按position大小排序
     *      3.判定是否可以追上：若追不上，则加一车队
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length;
        int nums=1;//车队数量
        if(len==0)
            return 0;
        Car[] cars=new Car[len];
        for(int i=0;i<len;i++){
            cars[i]=new Car(position[i],speed[i]);
        }
        Arrays.sort(cars);
        Car frontCar=cars[len-1];
        for(int i=len-2;i>=0;i--){
            if(!isMeet(frontCar,cars[i],target)){
                nums++;
                frontCar=cars[i];
            }
        }
        return nums;
    }

    /**
     * carOne.postion>carTwo.postion
     * true: 二可追上一 false:二追不上一
     * @param carOne
     * @param carTwo
     * @param target
     * @return
     */
    public boolean isMeet(Car carOne,Car carTwo,int target){
        double carOneTime=(double) (target-carOne.position)/carOne.speed;
        double carTwoTime=(double) (target-carTwo.position)/carTwo.speed;
        if(carOneTime<carTwoTime){
            return false;
        }
        else {
            return true;
        }
    }

}
class Car implements Comparable<Car> {
    int position;
    int speed;

    public Car(int position,int speed){
        this.position=position;
        this.speed=speed;
    }

    @Override
    public int compareTo(Car car) {
        return this.position-car.position;
    }
}