package org.to.studies.polar;

import org.to.studies.vector.Vector2D;

public class PolarInheritance2D extends Vector2D {
    public PolarInheritance2D(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        return Math.atan(super.getComponents()[1] / super.getComponents()[0]);
    }
}
