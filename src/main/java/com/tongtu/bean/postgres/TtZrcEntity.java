package com.tongtu.bean.postgres;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.hibernate.annotations.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zrc")
@Entity
public class TtZrcEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, insertable = true, unique = true, updatable = true, length = 36)
    private String id;
    @Basic
    @Column(name = "bm", unique = false, insertable = true, updatable = true, length = 15, precision = 15)
    private String zrcbm;
    @Basic
    @Column(name = "mc", insertable = true, updatable = true, length = 200, precision = 200)
    private String zrcmc;
    @Basic
    @Column(name = "rksl", nullable = true, insertable = true, updatable = true, length = 18, precision = 0)
    private BigInteger rksl;
    @Basic
    @Column(name = "hsl", nullable = true, insertable = true, updatable = true, length = 18, precision = 0)
    private BigInteger zrchs;
    @Basic
    @Column(name = "jzcbm", insertable = true, updatable = true, length = 12, precision = 12)
    private String jzcbm;
    @Basic
    @Column(name = "x", insertable = true, updatable = true, precision = 14, scale = 8)
    private Double longitude;
    @Basic
    @Column(name = "y", insertable = true, updatable = true, precision = 14, scale = 8)
    private Double latitude;
    @Basic
    @Column(name = "z", insertable = true, updatable = true, precision = 14, scale = 8)
    private Double altitude;
    @Basic
    @Column(name = "bz", insertable = true, updatable = true, length = 500, precision = 500)
    private String bz;

//    @Column(name = "the_geom", columnDefinition = "geometry(PointZ,4326)")
    @Column(name = "the_geom", columnDefinition = "geometry(Point,4326)")
    private Point location;

    @PrePersist
    public void toJTSGeometry() {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.maximumPreciseValue), 4326);
        Coordinate coordinate = new Coordinate(this.getLongitude(), this.getLatitude(), this.getAltitude());
        this.location = geometryFactory.createPoint(coordinate);
    }

}
