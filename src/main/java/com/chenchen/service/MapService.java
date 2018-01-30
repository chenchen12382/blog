package com.chenchen.service;


import com.chenchen.dao.MapDao;
import com.chenchen.model.Center;
import com.chenchen.model.Sql;
import com.chenchen.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/5.
 */
@Service
public class MapService {

    @Autowired
    private MapDao mapDao;

    public  void test() {
        //循环判断
        List<Sql> sqls = mapDao.findAllSql();

        List<Center> centers=mapDao.findAllCenter();

//        for (Center item:centers){
//            System.out.println(item.getCenter());
//        }
        Double lat1=0.0;
        Double lng1=0.0;
        Double lat2=0.0;
        Double lng2=0.0;
//        Double temp=0.0;
        String center = "";
        //循环判断
        for (int i=0 ; i<sqls.size();i++){
            lat1=sqls.get(i).getLat();
            lng1=sqls.get(i).getLng();
            Double temp=0.0;
            for (int j=0;j<centers.size();j++){
                lat2=centers.get(j).getLat();
                lng2=centers.get(j).getLng();
                 Double temp1=MapUtil.getDistance(lat1,lng1,lat2,lng2);
                //判断
                if(temp1<temp || j==0){
                    temp=temp1;
                    center=centers.get(j).getCenter();
                }

            }
            Integer id = sqls.get(i).getId();
            mapDao.updateSql(id,center);
        }
    }
}
