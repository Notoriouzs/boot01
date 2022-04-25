package com.hz.boot01.dao;

import com.hz.boot01.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 供应商dao接口
 */
public interface ProviderDao {

    /**
     *
     * @param pyl
     * @param pageSize
     * @param proName
     * @param proDesc
     * @return
     */
    public List<Provider> findProviderList(@Param("pyl") Integer pyl,
                                            @Param("pageSize") Integer pageSize,
                                            @Param("proName") String proName,
                                           @Param("proDesc") String proDesc
    );


    public Integer findProviderCount();


    /**
     * 根据ID  获得供应商对象
     * @param id
     * @return
     */
    public Provider findProviderById(Integer id);

    /**
     *
     * @param provider
     * @return
     */
    public Integer addProvider(@Param("provider") Provider provider);

    /**
     *
     * @param provider
     * @return
     */
    public Integer updateProvider(Provider provider);

    /**
     *
     * @param id
     * @return
     */

    public int deleteProviderById(Integer id);



}
