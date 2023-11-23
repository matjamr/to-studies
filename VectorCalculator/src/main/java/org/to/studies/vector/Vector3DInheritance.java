package org.to.studies.vector;

public class Vector3DInheritance extends Vector2D {

    private double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double cdot(IVector param){
        return super.getComponents()[0]*
                param.getComponents()[0]+
                super.getComponents()[1]*
                        param.getComponents()[1]+
                z *0;
    }

    @Override
    public double[] getComponents() {
        return new double[]{
                super.getComponents()[0]
                , super.getComponents()[1], z};
    }

    public double abs() {
        return Math.sqrt(super.getComponents()[0]*
                super.getComponents()[0]+
                super.getComponents()[1]*
                        super.getComponents()[1]+z *z);
    }

    public Vector2D cross(IVector params) {
        double _temp_x = y * params.getComponents()[2] - z * params.getComponents()[1];
        double _temp_y = z * params.getComponents()[0] - x * params.getComponents()[2];
        double _temp_z = x * params.getComponents()[1] - y * params.getComponents()[0];
        return new Vector3DDecorator(new Vector2D(_temp_x, _temp_y), _temp_z);
    }

    public Vector2D gerSrc() {
        return this;
    }
}
