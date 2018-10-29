package classes;

import Shape.Shape;

import java.text.DecimalFormat;

public class GetVolume {
    public double volumeBol(Shape shape){
        double volume = (4.0/3.0) * Math.PI * Math.pow(shape.getRay(), 3);
        DecimalFormat df = new DecimalFormat("#,##");
        volume = Double.valueOf(df.format(volume));
        return volume;
    }
    public Double volumeCilinder(Shape shape){
        double volume = Math.PI * Math.pow(shape.getRay(), 2) * shape.getHeight();
        DecimalFormat df = new DecimalFormat("#,##");
        volume = Double.valueOf(df.format(volume));
        return volume;
    }
    public Double volumeBlok(Shape shape){
        double volume = shape.getLength() * shape.getWidth() * shape.getHeight();
        DecimalFormat df = new DecimalFormat("#,##");
        volume = Double.valueOf(df.format(volume));
        return volume;
    }
    public Double volumeKegel(Shape shape){
        double volume = (Math.PI * shape.getRay()) * shape.getHeight() / 3;
        DecimalFormat df = new DecimalFormat("#,##");
        volume = Double.valueOf(df.format(volume));
        return volume;
    }
    public Double volumePiramide(Shape shape){
        double volume = shape.getLength() * shape.getWidth() * shape.getHeight() / 3;
        DecimalFormat df = new DecimalFormat("#,##");
        volume = Double.valueOf(df.format(volume));
        return volume;
    }
}