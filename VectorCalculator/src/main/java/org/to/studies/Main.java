package org.to.studies;

import org.to.studies.polar.Polar2DAdapter;
import org.to.studies.polar.PolarInheritance2D;
import org.to.studies.vector.Vector2D;
import org.to.studies.vector.Vector3DDecorator;
import org.to.studies.vector.Vector3DInheritance;

public class Main {
    public static void main(String[] args) {
        final Vector2D tmpVector2D = new Vector2D(2, 5);
        final Polar2DAdapter vector2d = new Polar2DAdapter(tmpVector2D);
        final Vector3DDecorator vector3dDecorator = new Vector3DDecorator(new Vector2D(3, 4), 1);
        final Vector3DInheritance vector3dInheritance = new Vector3DInheritance(1,5,4);

        System.out.println("Wektory - uklad kartezjanski");
        System.out.printf("Vector 2D - [x: %s, y: %s]%n", vector2d.getComponents()[0], vector2d.getComponents()[1]);
        System.out.printf("Vector 3D Inheritance - [x: %s, y: %s, z: %s]%n",  vector3dDecorator.getComponents()[0], vector3dDecorator.getComponents()[1], vector3dDecorator.getComponents()[2]);
        System.out.printf("Vector 3D Decorator - [x: %s, y: %s, z: %s]%n",  vector3dInheritance.getComponents()[0], vector3dInheritance.getComponents()[1], vector3dInheritance.getComponents()[2]);

        System.out.println("------------------------------------------------------");

        System.out.println("\nUklad biegunowy ");
        System.out.printf("Vector 2D: %n\tpromien: %s%n\tkat: %s%n", vector2d.abs(), vector2d.getAngle());

        System.out.println("------------------------------------------------------");

        System.out.println("\nIloczyn wektorowy");
        System.out.println("Vector3dInheritance x Vector2D");
        var wektor1 = vector3dInheritance.cross(vector2d);
        System.out.printf("[x: %s, y: %s, z: %s]%n",  wektor1.getComponents()[0], wektor1.getComponents()[1], wektor1.getComponents()[2]);

        System.out.println("Vector3dDecorator x Vector2D");
        var wektor2 = vector3dDecorator.cross(vector2d);
        System.out.printf("[x: %s, y: %s, z: %s]%n",  wektor2.getComponents()[0], wektor2.getComponents()[1], wektor2.getComponents()[2]);

        System.out.println("Vector3dInheritance x Vector3dDecorator");
        var wektor3 = vector3dInheritance.cross(vector3dDecorator);
        System.out.printf("[x: %s, y: %s, z: %s]%n",  wektor3.getComponents()[0], wektor3.getComponents()[1], wektor3.getComponents()[2]);

        System.out.println("------------------------------------------------------");

        System.out.println("\nIloczyn skalarny");
        System.out.println("Vector2D x Vector3dInheritance: " + vector2d.cdot(vector3dInheritance));
        System.out.println("Vector2D x Vector3dDecorator: " + vector2d.cdot(vector3dDecorator));
        System.out.println("Vector3dDecorator x Vector3dInheritance: " + vector3dDecorator.cdot(vector3dInheritance));
    }
}