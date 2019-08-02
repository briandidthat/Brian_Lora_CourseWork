package com.company.concreteapproach;

/*Task:
 *
 */
public class Triangle extends Shape {
    public int hypotenuse;
    public int opposite;
    public int adjacent;

    public int getAdjacent() {
        return adjacent;
    }

    public int getOpposite() {
        return opposite;
    }

    public int getHypotenuse() {
        return hypotenuse;
    }

    public void setAdjacent(int adjacent) {
        this.adjacent = adjacent;
    }

    public void setHypotenuse(int hypotenuse) {
        this.hypotenuse = hypotenuse;
    }

    public void setOpposite(int opposite) {
        this.opposite = opposite;
    }


}
