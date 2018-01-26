package com.tongtu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequenceFactory;
import org.hibernate.annotations.Type;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    private String htProperty;
    private String roadName;
    private String videoName;
    private List<Point> points;

    public LineString convertToJTSGeometry() {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.maximumPreciseValue), 4326);
        if (this.points.size() < 2)
            return null;
        Coordinate[] coordinates = new Coordinate[this.points.size()];
        int i = 0;
        for (Point coor : this.points) {
            Coordinate coordinate = new Coordinate(coor.getLon(), coor.getLat(), coor.getAlt());
            coordinates[i++] = coordinate;
        }
       return geometryFactory.createLineString(coordinates);
    }
}
