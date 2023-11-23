package org.to.studies.vector;

import lombok.AllArgsConstructor;

public class Vector3D extends Vector2D {
    private double z;

    public Vector3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }


    @Override
    public double abs() {
        return super.abs();
    }

    @Override
    public double cdot(IVector iVector) {
        return super.cdot(iVector);
    }

    @Override
    public double[] getComponents() {
        return super.getComponents();
    }
}
