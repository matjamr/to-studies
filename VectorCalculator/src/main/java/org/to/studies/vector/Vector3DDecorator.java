package org.to.studies.vector;

import java.util.Optional;

public class Vector3DDecorator extends Vector2D {
    private IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector ivector, double z) {
        super(ivector.getComponents()[0], ivector.getComponents()[1]);
        srcVector = ivector;
        this.z = z;
    }

    @Override
    public double abs() {
        return Math.sqrt(srcVector.getComponents()[0] * srcVector.getComponents()[0] +
                srcVector.getComponents()[1] * srcVector.getComponents()[1] +
                z * z);
    }

    @Override
    public double cdot(IVector iVector) {
        return srcVector.getComponents()[0] * iVector.getComponents()[0] +
                z * iVector.getComponents()[2] +
                srcVector.getComponents()[1] * iVector.getComponents()[1];
    }

    @Override
    public double[] getComponents() {
        return new double[]{
                srcVector.getComponents()[0],
                srcVector.getComponents()[1],
                z
        };
    }

    public Vector2D cross(IVector params) {
        double _temp_x = srcVector.getComponents()[1] * params.getComponents()[2] - z * params.getComponents()[1];
        double _temp_y = z * params.getComponents()[0] - srcVector.getComponents()[0] * params.getComponents()[2];
        double _temp_z = srcVector.getComponents()[0] * params.getComponents()[1] - srcVector.getComponents()[1] * params.getComponents()[0];
        return new Vector3DDecorator(new Vector2D(_temp_x, _temp_y), _temp_z);
    }

    public IVector getSrc() {
        return srcVector;
    }
}
