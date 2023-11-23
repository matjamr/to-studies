package org.to.studies.polar;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.to.studies.vector.IVector;
import org.to.studies.vector.Vector2D;

@AllArgsConstructor
@Data
public class Polar2DAdapter implements IPolar2D, IVector {

    private Vector2D srcVector;

    @Override
    public double getAngle() {
        var rad = Math.atan2(srcVector.getComponents()[1], srcVector.getComponents()[0]);
        var degrees = rad * 180 / Math.PI;
        if(degrees < 0)
            return degrees += 360;
        return degrees;
    }

    @Override
    public double abs() {
        return srcVector.abs();
    }

    @Override
    public double cdot(IVector iVector) {
        return srcVector.cdot(iVector);
    }

    @Override
    public double[] getComponents() {
        return srcVector.getComponents();
    }


}
