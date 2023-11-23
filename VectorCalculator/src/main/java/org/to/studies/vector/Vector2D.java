package org.to.studies.vector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vector2D implements IVector {
    protected double x;
    protected double y;

    @Override
    public double abs() {
        return Math.sqrt(x * x + y*y);
    }

    @Override
    public double cdot(IVector iVector) {
        return iVector.getComponents()[0] * x + iVector.getComponents()[1] * y;
    }

    @Override
    public double[] getComponents() {
        return new double[]{x, y, 0};
    }
}
