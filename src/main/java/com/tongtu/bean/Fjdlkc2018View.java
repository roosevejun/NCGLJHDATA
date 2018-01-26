package com.tongtu.bean;

import com.vividsolutions.jts.geom.LineString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.geometry.Precision;
import org.opengis.geometry.PrecisionFactory;
import org.opengis.geometry.PrecisionType;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fjdlkc2018View {
    @Id
    private String crowid;
    private String xmcode;

    private String xmxzqhcode;

    private String xmxzqhxian;

    private String ssxzmc;

    private String ssxzbm;

    private String xmname;

    private Integer ctgctype;

    private String xmjhnf;

    private BigDecimal xmndjhcgstz;

    private BigDecimal xmndjhdftz;

    private BigDecimal xmndjztz;

    private String spwh;

    private String xmsjpf;

    private String ctgcguid;

    private String lxmc;

    private String lxbm;

    private String jsdj;

    private String jsdjhy;

    private String lmlx;

    private String lmlxhy;

    private BigDecimal ljkd;

    private BigDecimal lmkd;

    private String qdmc;

    private String zdmc;

    private BigDecimal qdzh;

    private BigDecimal zdzh;

    private BigDecimal jslc;

    private String gmkgnf;

    private String gmwgnf;

    private String coordinates;

    public SimpleFeatureType convertToSimpleFeatureType() {


        SimpleFeatureTypeBuilder b = new SimpleFeatureTypeBuilder();
    //set the name
        b.setName("Fjdlkc");
    //add some properties
        b.add("crowid", String.class);
        b.add("xmcode", String.class);
        b.add("xmxzqhcode", String.class);
        b.add("xmxzqhxian", String.class);
        b.add("ssxzmc", String.class);
        b.add("ssxzbm", String.class);
        b.add("xmname", String.class);
        b.add("ctgctype", Integer.class);
        b.length(4).add("xmjhnf", String.class);
        b.length(10).userData("decimalCount",3).add("cgstz", Double.class);
        b.length(10).userData("decimalCount",3).add("dftz", Double.class);
        b.length(10).userData("decimalCount",3).add("ztz", Double.class);
        b.add("spwh", String.class);
        b.add("xmsjpf", String.class);
        b.add("ctgcguid", String.class);
        b.add("lxmc", String.class);
        b.add("lxbm", String.class);
        b.add("jsdj", String.class);
        b.add("jsdjhy", String.class);
        b.add("lmlx", String.class);
        b.add("lmlxhy", String.class);
        b.length(10).userData("decimalCount",3).add("ljkd", Double.class);
        b.length(10).userData("decimalCount",3).add("lmkd", Double.class);
        b.add("qdmc", String.class);
        b.add("zdmc", String.class);
        b.length(10).userData("decimalCount",3).add("qdzh", Double.class);
        b.length(10).userData("decimalCount",3).add("zdzh", Double.class);
        b.length(10).userData("decimalCount",3).add("jslc", Double.class);
        b.add("gmkgnf", String.class);
        b.add("gmwgnf", String.class);
    //add a geometry property
        b.setCRS(DefaultGeographicCRS.WGS84); // set crs first
        b.add("the_geom", LineString.class); // then add geometry
        b.setDefaultGeometry("the_geom");
        return b.buildFeatureType();
    }
    public SimpleFeature buildFeature(int index,SimpleFeatureType type,LineString lineString) {
        SimpleFeatureBuilder builder  = new SimpleFeatureBuilder (type);
        builder.set("crowid",crowid);
        builder.set("xmcode", xmcode);
        builder.set("xmxzqhcode", xmxzqhcode);
        builder.set("xmxzqhxian",xmxzqhxian);
        builder.set("ssxzmc",ssxzmc);
        builder.set("ssxzbm", ssxzbm);
        builder.set("xmname", xmname);
        builder.set("ctgctype",ctgctype);
        builder.set("xmjhnf", xmjhnf);
        builder.set("cgstz", xmndjhcgstz.setScale(3, BigDecimal.ROUND_HALF_EVEN).toString());
        builder.set("dftz",  xmndjhdftz.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("ztz", xmndjztz.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("spwh", spwh);
        builder.set("xmsjpf", xmsjpf);
        builder.set("ctgcguid",ctgcguid);
        builder.set("lxmc", lxmc);
        builder.set("lxbm", lxbm);
        builder.set("jsdj", jsdj);
        builder.set("jsdjhy", jsdjhy);
        builder.set("lmlx", lmlx);
        builder.set("lmlxhy", lmlxhy);
        builder.set("ljkd", ljkd.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("lmkd", lmkd.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("qdmc", qdmc);
        builder.set("zdmc", zdmc);
        builder.set("qdzh", qdzh.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("zdzh", zdzh.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("jslc", jslc.setScale(3, BigDecimal.ROUND_HALF_EVEN).doubleValue());
        builder.set("gmkgnf",gmkgnf);
        builder.set("gmwgnf", gmwgnf);
        builder.set("the_geom",lineString);
        return builder.buildFeature( "fid."+index );
    }
}
