package com.tongtu.repository;

import com.tongtu.bean.Fjdlkc2018View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Fjdlkc2018ViewRepository extends JpaRepository<Fjdlkc2018View, String> {

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from fjdlkc2018 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getFjdlkc2018ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from cbc2018 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getcbc2018ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from cbc20162017 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getcbc20162017ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from jdzrc2018 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getjdzrc2018ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from jdzrc20162017 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getjdzrc20162017ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from jk2018 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getjk2018ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from jk20162017 v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getjk20162017ViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from xiangjictgc v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getxiangjictgcViewResult();

    @Query(value = "select  v.crowid as crowid, v.xmcode as xmcode, v.xmxzqhcode as xmxzqhcode, v.xmxzqhxian as xmxzqhxian, v.ssxzmc as ssxzmc, v.ssxzbm as ssxzbm, v.xmname as xmname, v.ctgctype as ctgctype, v.xmjhnf as xmjhnf, v.xmndjhcgstz as xmndjhcgstz, v.xmndjhdftz as xmndjhdftz, v.xmndjztz as xmndjztz, v.spwh as spwh, v.xmsjpf as xmsjpf, v.ctgcguid as ctgcguid, v.lxmc as lxmc, v.lxbm as lxbm, v.lxbm as lxbm, v.jsdj as jsdj, v.jsdjhy as jsdjhy, v.lmlx as lmlx, v.lmlxhy as lmlxhy, v.ljkd as ljkd, v.lmkd as lmkd, v.qdmc as qdmc, v.zdmc as zdmc, v.qdzh as qdzh, v.zdzh as zdzh, v.jslc as jslc,  v.gmkgnf as gmkgnf, v.gmwgnf as gmwgnf, v.coordinates as coordinates  from xianjictgc v where v.coordinates is not null", nativeQuery = true)
    List<Fjdlkc2018View> getxianjictgcViewResult();

}
