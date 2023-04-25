package exercise;

// BEGIN
class Cottage implements Home {

    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж " +
                "площадью " + area + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Flat another) {
        return Double.compare(getArea(), another.getArea());
    }
}
// END
